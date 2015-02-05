package com.baidu.tieba.mention;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SingleMentionActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mvc.core.MvcActivity;
import java.util.List;
/* loaded from: classes.dex */
public class SingleMentionActivity extends MvcActivity<n, com.baidu.tbadk.mvc.core.b, SingleMentionActivity> implements com.baidu.tbadk.core.voice.o {
    private com.baidu.tbadk.mvc.core.b bck;
    private BdUniqueId[] bcl;
    private n bub;
    private af buc;
    private j bud;
    VoiceManager mVoiceManager;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(SingleMentionActivityConfig.class, SingleMentionActivity.class);
        SingleMentionActivityConfig.setMentionActivityClass(SingleMentionActivity.class);
    }

    private BdUniqueId dt(boolean z) {
        if (this.bcl == null) {
            this.bcl = new BdUniqueId[2];
            this.bcl[0] = BdUniqueId.gen();
            this.bcl[1] = BdUniqueId.gen();
        }
        return z ? this.bcl[0] : this.bcl[1];
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.core.e
    /* renamed from: OQ */
    public com.baidu.tbadk.mvc.core.b kp() {
        if (this.bck == null) {
            this.bck = new com.baidu.tbadk.mvc.core.b(this);
            ab abVar = new ab(this);
            abVar.setUniqueId(dt(true));
            this.bck.a(abVar);
            f fVar = new f(this);
            fVar.setUniqueId(dt(false));
            this.bck.a(fVar);
        }
        return this.bck;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.core.e
    /* renamed from: Uo */
    public n kr() {
        if (this.bub == null) {
            this.bub = new n(this);
            this.buc = new af(this);
            this.buc.setUniqueId(dt(true));
            this.bub.a(this.buc);
            this.bud = new j(this);
            this.bud.setUniqueId(dt(false));
            this.bub.a(this.bud);
        }
        return this.bub;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UtilHelper.startHardAccelerated(getWindow());
        MentionActivityConfig.newJumpIn = true;
        wH().addEventDelegate(this);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onCreate(getPageContext());
        }
        addGlobalLayoutListener();
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
            if (this.buc == null) {
                finish();
                return true;
            } else if (this.buc.wT()) {
                return true;
            } else {
                finish();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.core.voice.o
    public com.baidu.tbadk.core.voice.m getRealView(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.o
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
        if (bVar.xm() == 9485) {
            com.baidu.tbadk.mvc.b.a xn = bVar.xn();
            if (xn instanceof FeedData) {
                return d((FeedData) xn);
            }
        } else if (bVar.xm() == 9484) {
            com.baidu.tbadk.mvc.b.a xn2 = bVar.xn();
            if (xn2 instanceof FeedData) {
                return e((FeedData) xn2);
            }
        } else if (bVar.xm() == 9483) {
            com.baidu.tbadk.mvc.b.a xn3 = bVar.xn();
            if (xn3 instanceof FeedData) {
                return f((FeedData) xn3);
            }
        } else if (bVar.xm() == 9486) {
            this.buc.b(bVar);
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
                return MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(getActivity(), kVar.getId(), kVar.Uh(), kVar.getPortrait(), feedData.getFname(), false, AddFriendActivityConfig.TYPE_REPLY_ME)));
            } else if (kr().getCurrentTabType() == 1) {
                TiebaStatic.eventStat(getActivity(), "chat_2_aio", "click", 1, new Object[0]);
                return MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getActivity(), com.baidu.adp.lib.g.c.a(feedData.getReplyer().getUserId(), 0L), feedData.getReplyer().getName_show(), feedData.getReplyer().getPortrait(), 0, feedData.getReplyer().getIsMyFriend(), feedData.toJson())));
            } else if (kr().getCurrentTabType() == 2) {
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
                if (kr().getCurrentTabType() == 2) {
                    com.baidu.tbadk.core.i.A(getActivity(), "new_at_me_visit_post");
                } else if (kr().getCurrentTabType() == 1) {
                    com.baidu.tbadk.core.i.A(getActivity(), "new_my_reply_visit_post");
                    if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                        com.baidu.tbadk.core.i.A(getActivity(), "zan_mlist");
                    }
                }
                return MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getActivity()).createSubPbCfg(feedData.getThread_id(), feedData.getPost_id(), "mention")));
            }
            if (kr().getCurrentTabType() == 2) {
                com.baidu.tbadk.core.i.A(getActivity(), "new_at_me_visit_pb");
            } else if (kr().getCurrentTabType() == 1) {
                com.baidu.tbadk.core.i.A(getActivity(), "new_my_reply_visit_pb");
                if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                    com.baidu.tbadk.core.i.A(getActivity(), "zan_mlist");
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
