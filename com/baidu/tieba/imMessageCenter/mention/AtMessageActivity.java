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
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import java.util.List;
/* loaded from: classes.dex */
public class AtMessageActivity extends BaseActivity<AtMessageActivity> implements ab.b, com.baidu.tbadk.mvc.c.a {
    private g dlR;
    private AtMeModelController dlS;
    private ViewEventCenter dlT;
    private CustomMessageListener dlU = new k(this, CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dlS = new AtMeModelController(this);
        registerListener(this.dlU);
        this.dlS.setUniqueId(getUniqueId());
        this.dlR = new g(this);
        if (bundle != null) {
            this.dlS.e(bundle);
        } else {
            this.dlS.e(null);
        }
        this.dlR.TS();
        Fw().addEventDelegate(this);
        this.dlS.TQ();
    }

    @Override // com.baidu.tbadk.core.view.ab.b
    public void aL(boolean z) {
        this.dlS.avk();
    }

    public void JO() {
        this.dlS.TR();
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean EM() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar.EN() == 9484) {
            com.baidu.tbadk.mvc.b.a EO = bVar.EO();
            if (EO instanceof FeedData) {
                return c((FeedData) EO);
            }
        } else if (bVar.EN() == 9483) {
            com.baidu.tbadk.mvc.b.a EO2 = bVar.EO();
            if (EO2 instanceof FeedData) {
                return b((FeedData) EO2);
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
                return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(thread_id, post_id, "mention", false, userName, false, post_id, 0)));
            }
            TiebaStatic.log("new_at_me_visit_pb");
            if (feedData.getThread_Type() == 33) {
                TiebaStatic.log("c10384");
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), feedData.getThread_id()).cb(feedData.getPost_id()).cc("mention").pg()));
                return false;
            }
            return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getActivity()).createNormalCfg(feedData.getThread_id(), feedData.getPost_id(), 1, "mention")));
        }
        return false;
    }

    public ViewEventCenter Fw() {
        if (this.dlT == null) {
            this.dlT = new ViewEventCenter();
        }
        return this.dlT;
    }

    public void avm() {
        this.dlR.avm();
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        this.dlR.b(bVar);
    }

    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        this.dlR.a(aVar);
    }

    public void avn() {
        this.dlR.avn();
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
        this.dlR.onChangeSkinType(getPageContext(), i);
    }
}
