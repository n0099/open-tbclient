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
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveCommentActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import java.util.List;
/* loaded from: classes2.dex */
public class ReplyMessageActivity extends BaseActivity<ReplyMessageActivity> implements j.b, VoiceManager.c, com.baidu.tbadk.mvc.c.a {
    private VoiceManager dBC;
    private ViewEventCenter eOk;
    private CustomMessageListener eOl = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (ReplyMessageActivity.this.ePl != null) {
                    ReplyMessageActivity.this.ePl.amd();
                }
            }
        }
    };
    private ReplyMeModelController ePl;
    private n ePm;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ePl = new ReplyMeModelController(this);
        this.ePl.k(bundle);
        this.ePl.setUniqueId(getUniqueId());
        this.ePm = new n(this);
        this.ePm.XJ();
        Nf().addEventDelegate(this);
        this.ePl.amd();
        registerListener(this.eOl);
        aMd();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.dBC = getVoiceManager();
        this.dBC.onCreate(getPageContext());
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Mw() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar.Mx() == 9485) {
            com.baidu.tbadk.mvc.b.a My = bVar.My();
            if (My instanceof FeedData) {
                return g((FeedData) My);
            }
        }
        if (bVar.Mx() == 9484) {
            com.baidu.tbadk.mvc.b.a My2 = bVar.My();
            if (My2 instanceof FeedData) {
                return c((FeedData) My2);
            }
        } else if (bVar.Mx() == 9483) {
            com.baidu.tbadk.mvc.b.a My3 = bVar.My();
            if (My3 instanceof FeedData) {
                return b((FeedData) My3);
            }
        } else if (bVar.Mx() == 9486) {
            this.ePm.d(bVar);
            return true;
        } else if (bVar.Mx() == 9488) {
            com.baidu.tbadk.mvc.b.a My4 = bVar.My();
            if (My4 instanceof FeedData) {
                FeedData feedData = (FeedData) My4;
                String str = null;
                if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                    str = "c12011";
                } else if (FeedData.TYPE_DECLARE.equals(feedData.getPraiseItemType())) {
                    str = "c12009";
                }
                if (str != null) {
                    TiebaStatic.log(new ak(str).aa("tid", feedData.getThread_id()));
                }
                return true;
            }
        }
        return false;
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
                    TiebaStatic.log(new ak(str).aa("tid", feedData.getThread_id()));
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
                createSubPbActivityConfig.setKeyPageStartFrom(12);
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
                TiebaStatic.log(new ak(str).aa("tid", feedData.getThread_id()));
            }
            if (feedData.getThread_Type() == 33) {
                TiebaStatic.log("c10384");
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), feedData.getThread_id()).cE(feedData.getPost_id()).cF("mention").wQ()));
                return false;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(feedData.getThread_id(), feedData.getPost_id(), 1, "mention");
            createNormalCfg.setStartFrom(12);
            if (feedData.getFromForumId() > 0) {
                createNormalCfg.setForumId(String.valueOf(feedData.getFromForumId()));
            }
            return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
        return false;
    }

    private boolean g(FeedData feedData) {
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

    @Override // com.baidu.tbadk.core.view.j.b
    public void onListPullRefresh(boolean z) {
        this.ePl.eS(z);
    }

    public ViewEventCenter Nf() {
        if (this.eOk == null) {
            this.eOk = new ViewEventCenter();
        }
        return this.eOk;
    }

    public void aLT() {
        this.ePm.aLT();
    }

    public void a(ErrorData errorData) {
        if (errorData != null && !StringUtils.isNull(errorData.error_msg)) {
            showToast(errorData.error_msg);
        }
    }

    public void aLU() {
        this.ePm.aLU();
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        this.ePm.b(bVar);
    }

    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        this.ePm.a(aVar);
    }

    public void WT() {
        this.ePl.ame();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ePm.d(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.ePm.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ePm.destroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT);
        if (this.dBC != null) {
            this.dBC.onDestory(getPageContext());
        }
    }

    private void aMd() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                return ReplyMessageActivity.this.ePm != null ? new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, Boolean.valueOf(ReplyMessageActivity.this.ePm.onBackPressed())) : new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, false);
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
        if (this.dBC == null) {
            this.dBC = VoiceManager.instance();
        }
        return this.dBC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dBC != null) {
            this.dBC.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.dBC != null) {
            this.dBC.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dBC != null) {
            this.dBC.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dBC != null) {
            this.dBC.onStop(getPageContext());
        }
    }
}
