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
    private g dgL;
    private AtMeModelController dgM;
    private ViewEventCenter dgN;
    private CustomMessageListener dgO = new k(this, CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dgM = new AtMeModelController(this);
        registerListener(this.dgO);
        this.dgM.setUniqueId(getUniqueId());
        this.dgL = new g(this);
        if (bundle != null) {
            this.dgM.f(bundle);
        } else {
            this.dgM.f(null);
        }
        this.dgL.UK();
        EY().addEventDelegate(this);
        this.dgM.UI();
    }

    @Override // com.baidu.tbadk.core.view.ae.b
    public void aM(boolean z) {
        this.dgM.asZ();
    }

    public void JC() {
        this.dgM.UJ();
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Eo() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar.Ep() == 9484) {
            com.baidu.tbadk.mvc.b.a Eq = bVar.Eq();
            if (Eq instanceof FeedData) {
                return c((FeedData) Eq);
            }
        } else if (bVar.Ep() == 9483) {
            com.baidu.tbadk.mvc.b.a Eq2 = bVar.Eq();
            if (Eq2 instanceof FeedData) {
                return b((FeedData) Eq2);
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
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), feedData.getThread_id()).ci(feedData.getPost_id()).cj("mention").pl()));
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

    public ViewEventCenter EY() {
        if (this.dgN == null) {
            this.dgN = new ViewEventCenter();
        }
        return this.dgN;
    }

    public void atb() {
        this.dgL.atb();
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        this.dgL.b(bVar);
    }

    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        this.dgL.a(aVar);
    }

    public void atc() {
        this.dgL.atc();
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
        this.dgL.onChangeSkinType(getPageContext(), i);
    }
}
