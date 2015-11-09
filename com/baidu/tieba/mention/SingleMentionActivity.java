package com.baidu.tieba.mention;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveCommentActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import java.util.List;
/* loaded from: classes.dex */
public class SingleMentionActivity extends BaseActivity<SingleMentionActivity> implements VoiceManager.c, com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter cbB;
    private n cbC;
    private al cbD;
    private j cbE;
    private ah cbF;
    private f cbG;
    VoiceManager mVoiceManager;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cbF = new ah(this);
        this.cbF.setUniqueId(getUniqueId());
        this.cbG = new f(this);
        this.cbG.setUniqueId(getUniqueId());
        this.cbC = new n(this);
        this.cbD = new al(this);
        this.cbE = new j(this);
        if (getIntent() != null) {
            this.cbF.f(getIntent().getExtras());
            this.cbG.f(getIntent().getExtras());
            this.cbC.h(getIntent().getExtras());
            this.cbD.h(getIntent().getExtras());
            this.cbE.h(getIntent().getExtras());
        } else if (bundle != null) {
            this.cbF.f(bundle);
            this.cbG.f(bundle);
            this.cbC.h(bundle);
            this.cbD.h(bundle);
            this.cbE.h(bundle);
        } else {
            this.cbF.f(null);
            this.cbG.f(null);
            this.cbC.h(null);
            this.cbD.h(null);
            this.cbE.h(null);
        }
        setContentView(this.cbC.pa());
        this.cbC.oR();
        this.cbC.a(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.cbC.adi();
        UtilHelper.startHardAccelerated(getWindow());
        MentionActivityConfig.newJumpIn = true;
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onCreate(getPageContext());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        oG().addEventDelegate(this);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.cbC.onNewIntent(intent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!this.cbD.onActivityResult(i, i2, intent) && i2 == -1) {
            switch (i) {
                case 12011:
                    Bundle extras = intent.getExtras();
                    String string = extras.getString("user_id");
                    String string2 = extras.getString("user_name");
                    String string3 = extras.getString(IntentConfig.PORTRAIT);
                    if (string2 != null && string != null) {
                        try {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getActivity(), Long.parseLong(string), string2, string3, 0)));
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.cbD.onSaveInstanceState(bundle);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cbC.adh();
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.cbD == null) {
                finish();
                return true;
            } else if (this.cbD.onBackPressed()) {
                return true;
            } else {
                finish();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b getRealView(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.mVoiceManager == null) {
            this.mVoiceManager = VoiceManager.instance();
        }
        return this.mVoiceManager;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
        if (this.cbD != null) {
            this.cbD.destroy();
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar.Ct() == 9485) {
            com.baidu.tbadk.mvc.b.a Cu = bVar.Cu();
            if (Cu instanceof FeedData) {
                return c((FeedData) Cu);
            }
        } else if (bVar.Ct() == 9484) {
            com.baidu.tbadk.mvc.b.a Cu2 = bVar.Cu();
            if (Cu2 instanceof FeedData) {
                return d((FeedData) Cu2);
            }
        } else if (bVar.Ct() == 9483) {
            com.baidu.tbadk.mvc.b.a Cu3 = bVar.Cu();
            if (Cu3 instanceof FeedData) {
                return e((FeedData) Cu3);
            }
        } else if (bVar.Ct() == 9486) {
            this.cbD.d(bVar);
            return true;
        }
        return false;
    }

    private boolean c(FeedData feedData) {
        if (feedData != null) {
            if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                List<LikeData> praiseList = feedData.getPraiseList();
                if (praiseList == null || praiseList.size() <= 0) {
                    return false;
                }
                LikeData likeData = praiseList.get(0);
                return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getActivity(), likeData.getId(), likeData.getNameShow(), likeData.getPortrait(), feedData.getFname(), false, AddFriendActivityConfig.TYPE_REPLY_ME)));
            } else if (this.cbC.getCurrentTabType() == 1) {
                TiebaStatic.eventStat(getActivity(), "chat_2_aio", "click", 1, new Object[0]);
                return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getActivity(), com.baidu.adp.lib.g.b.c(feedData.getReplyer().getUserId(), 0L), feedData.getReplyer().getName_show(), feedData.getReplyer().getPortrait(), 0, feedData.getReplyer().getIsMyFriend(), feedData.toJson())));
            } else if (this.cbC.getCurrentTabType() == 2) {
                return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getActivity(), feedData.getReplyer().getUserId(), feedData.getReplyer().getName_show(), feedData.getReplyer().getPortrait(), feedData.getFname(), false, AddFriendActivityConfig.TYPE_AT_ME)));
            } else {
                return false;
            }
        }
        return false;
    }

    private boolean d(FeedData feedData) {
        if (feedData != null) {
            if (feedData.getIsFloor()) {
                if (this.cbC.getCurrentTabType() == 2) {
                    TiebaStatic.log("new_at_me_visit_post");
                } else if (this.cbC.getCurrentTabType() == 1) {
                    TiebaStatic.log("new_my_reply_visit_post");
                    if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                        TiebaStatic.log("zan_mlist");
                    }
                }
                String thread_id = feedData.getThread_id();
                String post_id = feedData.getPost_id();
                if (feedData.getThread_Type() == 33) {
                    return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveCommentActivityConfig(getPageContext().getPageActivity()).createPhotoLiveCommentActivityConfig(thread_id, post_id, false)));
                }
                return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(thread_id, post_id, "mention", false)));
            }
            if (this.cbC.getCurrentTabType() == 2) {
                TiebaStatic.log("new_at_me_visit_pb");
            } else if (this.cbC.getCurrentTabType() == 1) {
                TiebaStatic.log("new_my_reply_visit_pb");
                if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                    TiebaStatic.log("zan_mlist");
                }
            }
            if (feedData.getThread_Type() == 33) {
                TiebaStatic.log("c10384");
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), feedData.getThread_id()).ce(feedData.getPost_id()).cf("mention").ri()));
                return false;
            }
            return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getActivity()).createNormalCfg(feedData.getThread_id(), feedData.getPost_id(), "mention")));
        }
        return false;
    }

    private boolean e(FeedData feedData) {
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

    public ViewEventCenter oG() {
        if (this.cbB == null) {
            this.cbB = new ViewEventCenter();
        }
        return this.cbB;
    }

    public al adv() {
        return this.cbD;
    }

    public j adw() {
        return this.cbE;
    }

    public ah adx() {
        return this.cbF;
    }

    public f ady() {
        return this.cbG;
    }

    public n adz() {
        return this.cbC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (errorData != null && !StringUtils.isNull(errorData.error_msg)) {
            showToast(errorData.error_msg);
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean oJ() {
        return false;
    }
}
