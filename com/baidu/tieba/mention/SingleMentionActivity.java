package com.baidu.tieba.mention;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mvc.core.MvcActivity;
import java.util.List;
/* loaded from: classes.dex */
public class SingleMentionActivity extends MvcActivity<n, com.baidu.tbadk.mvc.core.b, SingleMentionActivity> implements com.baidu.tbadk.core.voice.j {
    private n bDK;
    private ai bDL;
    private j bDM;
    private com.baidu.tbadk.mvc.core.b bdK;
    private BdUniqueId[] bdL;
    VoiceManager mVoiceManager;

    private BdUniqueId dv(boolean z) {
        if (this.bdL == null) {
            this.bdL = new BdUniqueId[2];
            this.bdL[0] = BdUniqueId.gen();
            this.bdL[1] = BdUniqueId.gen();
        }
        return z ? this.bdL[0] : this.bdL[1];
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.core.e
    /* renamed from: Qz */
    public com.baidu.tbadk.mvc.core.b oi() {
        if (this.bdK == null) {
            this.bdK = new com.baidu.tbadk.mvc.core.b(this);
            ae aeVar = new ae(this);
            aeVar.setUniqueId(dv(true));
            this.bdK.a(aeVar);
            f fVar = new f(this);
            fVar.setUniqueId(dv(false));
            this.bdK.a(fVar);
        }
        return this.bdK;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.core.e
    /* renamed from: XV */
    public n ok() {
        if (this.bDK == null) {
            this.bDK = new n(this);
            this.bDL = new ai(this);
            this.bDL.setUniqueId(dv(true));
            this.bDK.a(this.bDL);
            this.bDM = new j(this);
            this.bDM.setUniqueId(dv(false));
            this.bDK.a(this.bDM);
        }
        return this.bDK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.startHardAccelerated(getWindow());
        MentionActivityConfig.newJumpIn = true;
        zZ().addEventDelegate(this);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onCreate(getPageContext());
        }
        addGlobalLayoutListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ok().onNewIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 12011:
                    Bundle extras = intent.getExtras();
                    String string = extras.getString("user_id");
                    String string2 = extras.getString("user_name");
                    String string3 = extras.getString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                    if (string2 != null && string != null) {
                        try {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getActivity(), Long.parseLong(string), string2, string3, 0)));
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bDL == null) {
                finish();
                return true;
            } else if (this.bDL.Al()) {
                return true;
            } else {
                finish();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.core.voice.j
    public com.baidu.tbadk.core.voice.i getRealView(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.j
    public VoiceManager getVoiceManager() {
        if (this.mVoiceManager == null) {
            this.mVoiceManager = VoiceManager.instance();
        }
        return this.mVoiceManager;
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.AF() == 9485) {
            com.baidu.tbadk.mvc.b.a AG = bVar.AG();
            if (AG instanceof FeedData) {
                return d((FeedData) AG);
            }
        } else if (bVar.AF() == 9484) {
            com.baidu.tbadk.mvc.b.a AG2 = bVar.AG();
            if (AG2 instanceof FeedData) {
                return e((FeedData) AG2);
            }
        } else if (bVar.AF() == 9483) {
            com.baidu.tbadk.mvc.b.a AG3 = bVar.AG();
            if (AG3 instanceof FeedData) {
                return f((FeedData) AG3);
            }
        } else if (bVar.AF() == 9486) {
            this.bDL.c(bVar);
            return true;
        }
        return false;
    }

    private boolean d(FeedData feedData) {
        if (feedData != null) {
            if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                List<k> praiseList = feedData.getPraiseList();
                if (praiseList == null || praiseList.size() <= 0) {
                    return false;
                }
                k kVar = praiseList.get(0);
                return MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(getActivity(), kVar.getId(), kVar.XK(), kVar.getPortrait(), feedData.getFname(), false, AddFriendActivityConfig.TYPE_REPLY_ME)));
            } else if (ok().getCurrentTabType() == 1) {
                TiebaStatic.eventStat(getActivity(), "chat_2_aio", "click", 1, new Object[0]);
                return MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getActivity(), com.baidu.adp.lib.g.c.a(feedData.getReplyer().getUserId(), 0L), feedData.getReplyer().getName_show(), feedData.getReplyer().getPortrait(), 0, feedData.getReplyer().getIsMyFriend(), feedData.toJson())));
            } else if (ok().getCurrentTabType() == 2) {
                return MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(getActivity(), feedData.getReplyer().getUserId(), feedData.getReplyer().getName_show(), feedData.getReplyer().getPortrait(), feedData.getFname(), false, AddFriendActivityConfig.TYPE_AT_ME)));
            } else {
                return false;
            }
        }
        return false;
    }

    private boolean e(FeedData feedData) {
        if (feedData != null) {
            if (feedData.getIsFloor()) {
                if (ok().getCurrentTabType() == 2) {
                    com.baidu.tbadk.core.k.A(getActivity(), "new_at_me_visit_post");
                } else if (ok().getCurrentTabType() == 1) {
                    com.baidu.tbadk.core.k.A(getActivity(), "new_my_reply_visit_post");
                    if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                        com.baidu.tbadk.core.k.A(getActivity(), "zan_mlist");
                    }
                }
                return MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getActivity()).createSubPbCfg(feedData.getThread_id(), feedData.getPost_id(), "mention")));
            }
            if (ok().getCurrentTabType() == 2) {
                com.baidu.tbadk.core.k.A(getActivity(), "new_at_me_visit_pb");
            } else if (ok().getCurrentTabType() == 1) {
                com.baidu.tbadk.core.k.A(getActivity(), "new_my_reply_visit_pb");
                if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                    com.baidu.tbadk.core.k.A(getActivity(), "zan_mlist");
                }
            }
            return MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getActivity()).createNormalCfg(feedData.getThread_id(), feedData.getPost_id(), "mention")));
        }
        return false;
    }

    private boolean f(FeedData feedData) {
        String str;
        String str2;
        List<k> praiseList;
        k kVar;
        if (feedData != null) {
            String userId = feedData.getReplyer().getUserId();
            String userName = feedData.getReplyer().getUserName();
            if (!TextUtils.isEmpty(userId) || (praiseList = feedData.getPraiseList()) == null || praiseList.size() <= 0 || (kVar = praiseList.get(0)) == null) {
                str = userName;
                str2 = userId;
            } else {
                str2 = kVar.getId();
                str = kVar.getName();
            }
            if (str2 != null && str2.length() > 0) {
                return MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getActivity(), str2, str)));
            }
        }
        return false;
    }
}
