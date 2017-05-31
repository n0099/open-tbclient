package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveCommentActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import java.util.List;
/* loaded from: classes2.dex */
public class AtMessageActivity extends BaseActivity<AtMessageActivity> implements ae.b, com.baidu.tbadk.mvc.c.a {
    private g dmh;
    private AtMeModelController dmi;
    private ViewEventCenter dmj;
    private CustomMessageListener dmk = new k(this, CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dmi = new AtMeModelController(this);
        registerListener(this.dmk);
        this.dmi.setUniqueId(getUniqueId());
        this.dmh = new g(this);
        if (bundle != null) {
            this.dmi.f(bundle);
        } else {
            this.dmi.f(null);
        }
        this.dmh.VN();
        ES().addEventDelegate(this);
        this.dmi.VK();
    }

    @Override // com.baidu.tbadk.core.view.ae.b
    public void onListPullRefresh(boolean z) {
        this.dmi.atU();
    }

    public void MC() {
        this.dmi.VL();
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Ei() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar.Ej() == 9484) {
            com.baidu.tbadk.mvc.b.a Ek = bVar.Ek();
            if (Ek instanceof FeedData) {
                return c((FeedData) Ek);
            }
        } else if (bVar.Ej() == 9483) {
            com.baidu.tbadk.mvc.b.a Ek2 = bVar.Ek();
            if (Ek2 instanceof FeedData) {
                return b((FeedData) Ek2);
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
        if (feedData != null) {
            if (feedData.getIsFloor()) {
                TiebaStatic.log("new_at_me_visit_post");
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
            TiebaStatic.log("new_at_me_visit_pb");
            if (feedData.getThread_Type() == 33) {
                TiebaStatic.log("c10384");
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), feedData.getThread_id()).ci(feedData.getPost_id()).cj("mention").pd()));
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

    public ViewEventCenter ES() {
        if (this.dmj == null) {
            this.dmj = new ViewEventCenter();
        }
        return this.dmj;
    }

    public void atW() {
        this.dmh.atW();
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        this.dmh.b(bVar);
    }

    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        this.dmh.a(aVar);
    }

    public void atX() {
        this.dmh.atX();
    }

    public void a(ErrorData errorData) {
        if (errorData != null && !StringUtils.isNull(errorData.error_msg)) {
            showToast(errorData.error_msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dmh.d(getPageContext(), i);
    }
}
