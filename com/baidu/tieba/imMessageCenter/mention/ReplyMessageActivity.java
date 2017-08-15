package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tbadk.core.atomData.StoryPageActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ReplyMessageActivity extends BaseActivity<ReplyMessageActivity> implements k.b, VoiceManager.c, com.baidu.tbadk.mvc.c.a {
    private VoiceManager cjJ;
    private ViewEventCenter dFV;
    private CustomMessageListener dFW = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (ReplyMessageActivity.this.dGV != null) {
                    ReplyMessageActivity.this.dGV.Yj();
                }
            }
        }
    };
    private ReplyMeModelController dGV;
    private n dGW;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dGV = new ReplyMeModelController(this);
        this.dGV.f(bundle);
        this.dGV.setUniqueId(getUniqueId());
        this.dGW = new n(this);
        this.dGW.Ym();
        FN().addEventDelegate(this);
        this.dGV.Yj();
        registerListener(this.dFW);
        aAk();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.cjJ = getVoiceManager();
        this.cjJ.onCreate(getPageContext());
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Fe() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar.Ff() == 9485) {
            com.baidu.tbadk.mvc.b.a Fg = bVar.Fg();
            if (Fg instanceof FeedData) {
                return j((FeedData) Fg);
            }
        }
        if (bVar.Ff() == 9484) {
            com.baidu.tbadk.mvc.b.a Fg2 = bVar.Fg();
            if (Fg2 instanceof FeedData) {
                return d((FeedData) Fg2);
            }
        } else if (bVar.Ff() == 9483) {
            com.baidu.tbadk.mvc.b.a Fg3 = bVar.Fg();
            if (Fg3 instanceof FeedData) {
                return b((FeedData) Fg3);
            }
        } else if (bVar.Ff() == 9486) {
            this.dGW.d(bVar);
            return true;
        } else if (bVar.Ff() == 9487) {
            com.baidu.tbadk.mvc.b.a Fg4 = bVar.Fg();
            if (Fg4 instanceof FeedData) {
                return i((FeedData) Fg4);
            }
        } else if (bVar.Ff() == 9488) {
            com.baidu.tbadk.mvc.b.a Fg5 = bVar.Fg();
            if (Fg5 instanceof FeedData) {
                FeedData feedData = (FeedData) Fg5;
                String str = null;
                if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                    str = "c12011";
                } else if (FeedData.TYPE_DECLARE.equals(feedData.getPraiseItemType())) {
                    str = "c12009";
                }
                if (str != null) {
                    TiebaStatic.log(new aj(str).aa("tid", feedData.getThread_id()));
                }
                return true;
            }
        } else if (bVar.Ff() == 9489) {
            com.baidu.tbadk.mvc.b.a Fg6 = bVar.Fg();
            if (Fg6 instanceof FeedData) {
                return c((FeedData) Fg6);
            }
        }
        return false;
    }

    private boolean i(FeedData feedData) {
        if (feedData == null) {
            return false;
        }
        TiebaStatic.log("c10967");
        if (!aAj()) {
            UtilHelper.showToast(getActivity(), d.l.plugin_config_not_found);
            return false;
        }
        PraiseListActivityConfig praiseListActivityConfig = new PraiseListActivityConfig(getPageContext().getPageActivity(), feedData.getThread_id(), feedData.getPost_id(), feedData.getTitle(), false);
        praiseListActivityConfig.setIsGraffitiPraiseList();
        praiseListActivityConfig.setIsAuthor(feedData.isAuthor());
        return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, praiseListActivityConfig));
    }

    private boolean aAj() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PraiseListActivityConfig.class);
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
        if (feedData == null) {
            return false;
        }
        ArrayList<MetaData> arrayList = new ArrayList<>();
        MetaData metaData = new MetaData();
        if (feedData.getType() == 1) {
            metaData.setUserIdLong(-1L);
        } else {
            metaData.setUserIdLong(TbadkCoreApplication.getCurrentAccountId());
        }
        metaData.setUserName(TbadkCoreApplication.getCurrentAccountName());
        arrayList.add(metaData);
        return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StoryPageActivityConfig(getActivity()).createNormalConfig(arrayList, 0, feedData.getFromForumId(), com.baidu.adp.lib.g.b.d(feedData.getThread_id(), 0L))));
    }

    private boolean d(FeedData feedData) {
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
                    TiebaStatic.log(new aj(str).aa("tid", feedData.getThread_id()));
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
                TiebaStatic.log(new aj(str).aa("tid", feedData.getThread_id()));
            }
            if (feedData.getThread_Type() == 33) {
                TiebaStatic.log("c10384");
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), feedData.getThread_id()).cz(feedData.getPost_id()).cA("mention").pn()));
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

    private boolean j(FeedData feedData) {
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
            return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getActivity(), com.baidu.adp.lib.g.b.d(feedData.getReplyer().getUserId(), 0L), feedData.getReplyer().getName_show(), feedData.getReplyer().getPortrait(), 0, feedData.getReplyer().getIsMyFriend(), feedData.toJson())));
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.view.k.b
    public void onListPullRefresh(boolean z) {
        this.dGV.dO(z);
    }

    public ViewEventCenter FN() {
        if (this.dFV == null) {
            this.dFV = new ViewEventCenter();
        }
        return this.dFV;
    }

    public void azZ() {
        this.dGW.azZ();
    }

    public void a(ErrorData errorData) {
        if (errorData != null && !StringUtils.isNull(errorData.error_msg)) {
            showToast(errorData.error_msg);
        }
    }

    public void aAa() {
        this.dGW.aAa();
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        this.dGW.b(bVar);
    }

    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        this.dGW.a(aVar);
    }

    public void Nv() {
        this.dGV.Yk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dGW.d(getPageContext(), i);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.dGW.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dGW.destroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT);
        if (this.cjJ != null) {
            this.cjJ.onDestory(getPageContext());
        }
    }

    private void aAk() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                return ReplyMessageActivity.this.dGW != null ? new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, Boolean.valueOf(ReplyMessageActivity.this.dGW.onBackPressed())) : new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, false);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cjJ == null) {
            this.cjJ = VoiceManager.instance();
        }
        return this.cjJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cjJ != null) {
            this.cjJ.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.cjJ != null) {
            this.cjJ.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cjJ != null) {
            this.cjJ.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cjJ != null) {
            this.cjJ.onStop(getPageContext());
        }
    }
}
