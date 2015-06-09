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
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mvc.core.MvcActivity;
import java.util.List;
/* loaded from: classes.dex */
public class SingleMentionActivity extends MvcActivity<n, com.baidu.tbadk.mvc.core.b, SingleMentionActivity> implements com.baidu.tbadk.core.voice.j {
    private n bGG;
    private ai bGH;
    private j bGI;
    private com.baidu.tbadk.mvc.core.b bgp;
    private BdUniqueId[] bgq;
    VoiceManager mVoiceManager;

    private BdUniqueId dG(boolean z) {
        if (this.bgq == null) {
            this.bgq = new BdUniqueId[2];
            this.bgq[0] = BdUniqueId.gen();
            this.bgq[1] = BdUniqueId.gen();
        }
        return z ? this.bgq[0] : this.bgq[1];
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.core.e
    /* renamed from: RO */
    public com.baidu.tbadk.mvc.core.b oy() {
        if (this.bgp == null) {
            this.bgp = new com.baidu.tbadk.mvc.core.b(this);
            ae aeVar = new ae(this);
            aeVar.setUniqueId(dG(true));
            this.bgp.a(aeVar);
            f fVar = new f(this);
            fVar.setUniqueId(dG(false));
            this.bgp.a(fVar);
        }
        return this.bgp;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.core.e
    /* renamed from: Zv */
    public n oA() {
        if (this.bGG == null) {
            this.bGG = new n(this);
            this.bGH = new ai(this);
            this.bGH.setUniqueId(dG(true));
            this.bGG.a(this.bGH);
            this.bGI = new j(this);
            this.bGI.setUniqueId(dG(false));
            this.bGG.a(this.bGI);
        }
        return this.bGG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.startHardAccelerated(getWindow());
        MentionActivityConfig.newJumpIn = true;
        AM().addEventDelegate(this);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onCreate(getPageContext());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        oA().onNewIntent(intent);
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
                    String string3 = extras.getString(com.baidu.tbadk.core.frameworkData.c.PORTRAIT);
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
            if (this.bGH == null) {
                finish();
                return true;
            } else if (this.bGH.AY()) {
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

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
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
        if (bVar.Bs() == 9485) {
            com.baidu.tbadk.mvc.b.a Bt = bVar.Bt();
            if (Bt instanceof FeedData) {
                return d((FeedData) Bt);
            }
        } else if (bVar.Bs() == 9484) {
            com.baidu.tbadk.mvc.b.a Bt2 = bVar.Bt();
            if (Bt2 instanceof FeedData) {
                return e((FeedData) Bt2);
            }
        } else if (bVar.Bs() == 9483) {
            com.baidu.tbadk.mvc.b.a Bt3 = bVar.Bt();
            if (Bt3 instanceof FeedData) {
                return f((FeedData) Bt3);
            }
        } else if (bVar.Bs() == 9486) {
            this.bGH.d(bVar);
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
                return MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(getActivity(), kVar.getId(), kVar.Zk(), kVar.getPortrait(), feedData.getFname(), false, AddFriendActivityConfig.TYPE_REPLY_ME)));
            } else if (oA().getCurrentTabType() == 1) {
                TiebaStatic.eventStat(getActivity(), "chat_2_aio", "click", 1, new Object[0]);
                return MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getActivity(), com.baidu.adp.lib.g.c.c(feedData.getReplyer().getUserId(), 0L), feedData.getReplyer().getName_show(), feedData.getReplyer().getPortrait(), 0, feedData.getReplyer().getIsMyFriend(), feedData.toJson())));
            } else if (oA().getCurrentTabType() == 2) {
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
                if (oA().getCurrentTabType() == 2) {
                    com.baidu.tbadk.core.k.A(getActivity(), "new_at_me_visit_post");
                } else if (oA().getCurrentTabType() == 1) {
                    com.baidu.tbadk.core.k.A(getActivity(), "new_my_reply_visit_post");
                    if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                        com.baidu.tbadk.core.k.A(getActivity(), "zan_mlist");
                    }
                }
                return MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(feedData.getThread_id(), feedData.getPost_id(), "mention", false)));
            }
            if (oA().getCurrentTabType() == 2) {
                com.baidu.tbadk.core.k.A(getActivity(), "new_at_me_visit_pb");
            } else if (oA().getCurrentTabType() == 1) {
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
