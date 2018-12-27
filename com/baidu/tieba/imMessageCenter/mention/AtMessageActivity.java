package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import java.util.List;
/* loaded from: classes4.dex */
public class AtMessageActivity extends BaseActivity<AtMessageActivity> implements j.b, com.baidu.tbadk.mvc.c.a {
    private d fgG;
    private AtMeModelController fgH;
    private ViewEventCenter fgI;
    private CustomMessageListener fgJ = new CustomMessageListener(2016321) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMessageActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (AtMessageActivity.this.fgH != null) {
                    AtMessageActivity.this.fgH.arB();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fgH = new AtMeModelController(this);
        registerListener(this.fgJ);
        this.fgH.setUniqueId(getUniqueId());
        this.fgG = new d(this);
        if (bundle != null) {
            this.fgH.p(bundle);
        } else {
            this.fgH.p(null);
        }
        this.fgG.acd();
        OM().addEventDelegate(this);
        this.fgH.arB();
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bH(boolean z) {
        this.fgH.aGA();
    }

    public void aDT() {
        this.fgH.arC();
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Od() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar.Oe() == 9484) {
            com.baidu.tbadk.mvc.b.a Of = bVar.Of();
            if (Of instanceof FeedData) {
                return c((FeedData) Of);
            }
        } else if (bVar.Oe() == 9483) {
            com.baidu.tbadk.mvc.b.a Of2 = bVar.Of();
            if (Of2 instanceof FeedData) {
                return b((FeedData) Of2);
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
                return MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getActivity(), str2, str)));
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
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(thread_id, post_id, "mention", false, feedData.getReplyer() == null ? "" : feedData.getReplyer().getUserName(), false, post_id, 0);
                if (feedData.getFromForumId() > 0) {
                    createSubPbActivityConfig.setKeyFromForumId(String.valueOf(feedData.getFromForumId()));
                }
                createSubPbActivityConfig.setKeyPageStartFrom(13);
                return MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            }
            TiebaStatic.log("new_at_me_visit_pb");
            PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(feedData.getThread_id(), feedData.getPost_id(), 1, "mention");
            createNormalCfg.setStartFrom(13);
            if (feedData.getFromForumId() > 0) {
                createNormalCfg.setForumId(String.valueOf(feedData.getFromForumId()));
            }
            return MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
        return false;
    }

    public ViewEventCenter OM() {
        if (this.fgI == null) {
            this.fgI = new ViewEventCenter();
        }
        return this.fgI;
    }

    public void aWp() {
        this.fgG.aWp();
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        this.fgG.b(bVar);
    }

    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        this.fgG.a(aVar);
    }

    public void aWq() {
        this.fgG.aWq();
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
        this.fgG.d(getPageContext(), i);
    }
}
