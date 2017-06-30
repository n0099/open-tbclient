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
import com.baidu.tbadk.core.view.ae;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes2.dex */
public class ReplyMessageActivity extends BaseActivity<ReplyMessageActivity> implements ae.b, VoiceManager.c, com.baidu.tbadk.mvc.c.a {
    private VoiceManager cci;
    private ViewEventCenter duf;
    private CustomMessageListener dug = new be(this, CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY);
    private ReplyMeModelController dvf;
    private av dvg;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dvf = new ReplyMeModelController(this);
        this.dvf.f(bundle);
        this.dvf.setUniqueId(getUniqueId());
        this.dvg = new av(this);
        this.dvg.Xe();
        Fp().addEventDelegate(this);
        this.dvf.Xb();
        registerListener(this.dug);
        axP();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.cci = getVoiceManager();
        this.cci.onCreate(getPageContext());
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean EF() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar.EG() == 9485) {
            com.baidu.tbadk.mvc.b.a EH = bVar.EH();
            if (EH instanceof FeedData) {
                return i((FeedData) EH);
            }
        }
        if (bVar.EG() == 9484) {
            com.baidu.tbadk.mvc.b.a EH2 = bVar.EH();
            if (EH2 instanceof FeedData) {
                return c((FeedData) EH2);
            }
        } else if (bVar.EG() == 9483) {
            com.baidu.tbadk.mvc.b.a EH3 = bVar.EH();
            if (EH3 instanceof FeedData) {
                return b((FeedData) EH3);
            }
        } else if (bVar.EG() == 9486) {
            this.dvg.d(bVar);
            return true;
        } else if (bVar.EG() == 9487) {
            com.baidu.tbadk.mvc.b.a EH4 = bVar.EH();
            if (EH4 instanceof FeedData) {
                return h((FeedData) EH4);
            }
        } else if (bVar.EG() == 9488) {
            com.baidu.tbadk.mvc.b.a EH5 = bVar.EH();
            if (EH5 instanceof FeedData) {
                FeedData feedData = (FeedData) EH5;
                String str = null;
                if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                    str = "c12011";
                } else if (FeedData.TYPE_DECLARE.equals(feedData.getPraiseItemType())) {
                    str = "c12009";
                }
                if (str != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.au(str).Z("tid", feedData.getThread_id()));
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
        if (!axO()) {
            UtilHelper.showToast(getActivity(), w.l.plugin_config_not_found);
            return false;
        }
        PraiseListActivityConfig praiseListActivityConfig = new PraiseListActivityConfig(getPageContext().getPageActivity(), feedData.getThread_id(), feedData.getPost_id(), feedData.getTitle(), false);
        praiseListActivityConfig.setIsGraffitiPraiseList();
        praiseListActivityConfig.setIsAuthor(feedData.isAuthor());
        return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, praiseListActivityConfig));
    }

    private boolean axO() {
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
                    TiebaStatic.log(new com.baidu.tbadk.core.util.au(str).Z("tid", feedData.getThread_id()));
                }
                String thread_id = feedData.getThread_id();
                String post_id = feedData.getPost_id();
                String userName = feedData.getReplyer() == null ? "" : feedData.getReplyer().getUserName();
                if (feedData.getThread_Type() == 33) {
                    return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveCommentActivityConfig(getPageContext().getPageActivity()).createPhotoLiveCommentActivityConfig(thread_id, post_id, false)));
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(thread_id, post_id, "mention", false, userName, false, post_id, 0);
                if (feedData.getFromForumId() > 0) {
                    createSubPbActivityConfig.setKeyFromForumId(String.valueOf(feedData.getFromForumId()));
                }
                return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
            }
            TiebaStatic.log("new_my_reply_visit_pb");
            if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                TiebaStatic.log("zan_mlist");
                str = "c12012";
            } else if (FeedData.TYPE_DECLARE.equals(feedData.getPraiseItemType())) {
                str = "c12010";
            }
            if (str != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au(str).Z("tid", feedData.getThread_id()));
            }
            if (feedData.getThread_Type() == 33) {
                TiebaStatic.log("c10384");
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), feedData.getThread_id()).co(feedData.getPost_id()).cp("mention").pa()));
                return false;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(feedData.getThread_id(), feedData.getPost_id(), 1, "mention");
            if (feedData.getFromForumId() > 0) {
                createNormalCfg.setForumId(String.valueOf(feedData.getFromForumId()));
            }
            return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
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

    @Override // com.baidu.tbadk.core.view.ae.b
    public void onListPullRefresh(boolean z) {
        this.dvf.dE(z);
    }

    public ViewEventCenter Fp() {
        if (this.duf == null) {
            this.duf = new ViewEventCenter();
        }
        return this.duf;
    }

    public void axE() {
        this.dvg.axE();
    }

    public void a(ErrorData errorData) {
        if (errorData != null && !StringUtils.isNull(errorData.error_msg)) {
            showToast(errorData.error_msg);
        }
    }

    public void axF() {
        this.dvg.axF();
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        this.dvg.b(bVar);
    }

    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        this.dvg.a(aVar);
    }

    public void Nu() {
        this.dvf.Xc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dvg.d(getPageContext(), i);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.dvg.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dvg.destroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT);
        if (this.cci != null) {
            this.cci.onDestory(getPageContext());
        }
    }

    private void axP() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, new bf(this));
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cci == null) {
            this.cci = VoiceManager.instance();
        }
        return this.cci;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cci != null) {
            this.cci.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.cci != null) {
            this.cci.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cci != null) {
            this.cci.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cci != null) {
            this.cci.onStop(getPageContext());
        }
    }
}
