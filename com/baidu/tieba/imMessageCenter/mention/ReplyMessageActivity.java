package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveCommentActivityConfig;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class ReplyMessageActivity extends BaseActivity<ReplyMessageActivity> implements ab.b, VoiceManager.c, com.baidu.tbadk.mvc.c.a {
    private VoiceManager bOT;
    private ViewEventCenter dmJ;
    private CustomMessageListener dmK = new bd(this, CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY);
    private ReplyMeModelController dnI;
    private au dnJ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dnI = new ReplyMeModelController(this);
        this.dnI.f(bundle);
        this.dnI.setUniqueId(getUniqueId());
        this.dnJ = new au(this);
        this.dnJ.Vr();
        FU().addEventDelegate(this);
        this.dnI.Vp();
        registerListener(this.dmK);
        ajx();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.bOT = getVoiceManager();
        this.bOT.onCreate(getPageContext());
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Fk() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar.Fl() == 9485) {
            com.baidu.tbadk.mvc.b.a Fm = bVar.Fm();
            if (Fm instanceof FeedData) {
                return i((FeedData) Fm);
            }
        }
        if (bVar.Fl() == 9484) {
            com.baidu.tbadk.mvc.b.a Fm2 = bVar.Fm();
            if (Fm2 instanceof FeedData) {
                return c((FeedData) Fm2);
            }
        } else if (bVar.Fl() == 9483) {
            com.baidu.tbadk.mvc.b.a Fm3 = bVar.Fm();
            if (Fm3 instanceof FeedData) {
                return b((FeedData) Fm3);
            }
        } else if (bVar.Fl() == 9486) {
            this.dnJ.d(bVar);
            return true;
        } else if (bVar.Fl() == 9487) {
            com.baidu.tbadk.mvc.b.a Fm4 = bVar.Fm();
            if (Fm4 instanceof FeedData) {
                return h((FeedData) Fm4);
            }
        } else if (bVar.Fl() == 9488) {
            com.baidu.tbadk.mvc.b.a Fm5 = bVar.Fm();
            if (Fm5 instanceof FeedData) {
                FeedData feedData = (FeedData) Fm5;
                String str = null;
                if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                    str = "c12011";
                } else if (FeedData.TYPE_DECLARE.equals(feedData.getPraiseItemType())) {
                    str = "c12009";
                }
                if (str != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as(str).aa("tid", feedData.getThread_id()));
                }
                return true;
            }
        }
        return false;
    }

    private boolean h(FeedData feedData) {
        if (feedData == null) {
            return false;
        }
        TiebaStatic.log("c10967");
        if (!awr()) {
            UtilHelper.showToast(getActivity(), w.l.plugin_config_not_found);
            return false;
        }
        PraiseListActivityConfig praiseListActivityConfig = new PraiseListActivityConfig(getPageContext().getPageActivity(), feedData.getThread_id(), feedData.getPost_id(), feedData.getTitle(), false);
        praiseListActivityConfig.setIsGraffitiPraiseList();
        praiseListActivityConfig.setIsAuthor(feedData.isAuthor());
        return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, praiseListActivityConfig));
    }

    private boolean awr() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PraiseListActivityConfig.class);
    }

    private boolean b(FeedData feedData) {
        String str;
        String str2;
        List<LikeData> praiseList;
        LikeData likeData;
        if (feedData != null) {
            String userId = feedData.getReplyer().getUserId();
            String userName = feedData.getReplyer().getUserName();
            if (!TextUtils.isEmpty(userId) || (praiseList = feedData.getPraiseList()) == null || praiseList.size() <= 0 || (likeData = praiseList.get(0)) == null) {
                str = userName;
                str2 = userId;
            } else {
                str2 = likeData.getId();
                str = likeData.getName();
            }
            if (str2 != null && str2.length() > 0) {
                return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getActivity(), str2, str)));
            }
        }
        return false;
    }

    private boolean c(FeedData feedData) {
        String str = null;
        if (feedData != null) {
            if (feedData.getIsFloor()) {
                TiebaStatic.log("new_my_reply_visit_post");
                if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                    TiebaStatic.log("zan_mlist");
                    str = "c12012";
                } else if (FeedData.TYPE_DECLARE.equals(feedData.getPraiseItemType())) {
                    str = "c12010";
                }
                if (str != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as(str).aa("tid", feedData.getThread_id()));
                }
                String thread_id = feedData.getThread_id();
                String post_id = feedData.getPost_id();
                String userName = feedData.getReplyer() == null ? "" : feedData.getReplyer().getUserName();
                if (feedData.getThread_Type() == 33) {
                    return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveCommentActivityConfig(getPageContext().getPageActivity()).createPhotoLiveCommentActivityConfig(thread_id, post_id, false)));
                }
                return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(thread_id, post_id, "mention", false, userName, false, post_id, 0)));
            }
            TiebaStatic.log("new_my_reply_visit_pb");
            if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                TiebaStatic.log("zan_mlist");
                str = "c12012";
            } else if (FeedData.TYPE_DECLARE.equals(feedData.getPraiseItemType())) {
                str = "c12010";
            }
            if (str != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as(str).aa("tid", feedData.getThread_id()));
            }
            if (feedData.getThread_Type() == 33) {
                TiebaStatic.log("c10384");
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), feedData.getThread_id()).ci(feedData.getPost_id()).cj("mention").pE()));
                return false;
            }
            return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getActivity()).createNormalCfg(feedData.getThread_id(), feedData.getPost_id(), 1, "mention")));
        }
        return false;
    }

    private boolean i(FeedData feedData) {
        if (feedData != null) {
            if (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType()) || FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                List<LikeData> praiseList = feedData.getPraiseList();
                if (praiseList == null || praiseList.size() <= 0) {
                    return false;
                }
                LikeData likeData = praiseList.get(0);
                return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getActivity(), likeData.getId(), likeData.getNameShow(), likeData.getPortrait(), feedData.getFname(), false, AddFriendActivityConfig.TYPE_REPLY_ME)));
            }
            TiebaStatic.eventStat(getActivity(), "chat_2_aio", "click", 1, new Object[0]);
            return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getActivity(), com.baidu.adp.lib.g.b.c(feedData.getReplyer().getUserId(), 0L), feedData.getReplyer().getName_show(), feedData.getReplyer().getPortrait(), 0, feedData.getReplyer().getIsMyFriend(), feedData.toJson())));
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.view.ab.b
    public void aN(boolean z) {
        this.dnI.dj(z);
    }

    public ViewEventCenter FU() {
        if (this.dmJ == null) {
            this.dmJ = new ViewEventCenter();
        }
        return this.dmJ;
    }

    public void awg() {
        this.dnJ.awg();
    }

    public void a(ErrorData errorData) {
        if (errorData != null && !StringUtils.isNull(errorData.error_msg)) {
            showToast(errorData.error_msg);
        }
    }

    public void awh() {
        this.dnJ.awh();
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        this.dnJ.b(bVar);
    }

    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        this.dnJ.a(aVar);
    }

    public void Ko() {
        this.dnI.Vq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dnJ.onChangeSkinType(getPageContext(), i);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.dnJ.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dnJ.destroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT);
        if (this.bOT != null) {
            this.bOT.onDestory(getPageContext());
        }
    }

    private void ajx() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, new be(this));
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bOT == null) {
            this.bOT = VoiceManager.instance();
        }
        return this.bOT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bOT != null) {
            this.bOT.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.bOT != null) {
            this.bOT.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bOT != null) {
            this.bOT.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bOT != null) {
            this.bOT.onStop(getPageContext());
        }
    }
}
