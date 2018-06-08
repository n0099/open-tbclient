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
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import java.util.List;
/* loaded from: classes2.dex */
public class AtMessageActivity extends BaseActivity<AtMessageActivity> implements f.b, com.baidu.tbadk.mvc.c.a {
    private d ezf;
    private AtMeModelController ezg;
    private ViewEventCenter ezh;
    private CustomMessageListener ezi = new CustomMessageListener(2016321) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMessageActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (AtMessageActivity.this.ezg != null) {
                    AtMessageActivity.this.ezg.aks();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ezg = new AtMeModelController(this);
        registerListener(this.ezi);
        this.ezg.setUniqueId(getUniqueId());
        this.ezf = new d(this);
        if (bundle != null) {
            this.ezg.i(bundle);
        } else {
            this.ezg.i(null);
        }
        this.ezf.UI();
        JT().addEventDelegate(this);
        this.ezg.aks();
    }

    @Override // com.baidu.tbadk.core.view.f.b
    public void aS(boolean z) {
        this.ezg.avn();
    }

    public void avl() {
        this.ezg.akt();
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Jk() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar.Jl() == 9484) {
            com.baidu.tbadk.mvc.b.a Jm = bVar.Jm();
            if (Jm instanceof FeedData) {
                return c((FeedData) Jm);
            }
        } else if (bVar.Jl() == 9483) {
            com.baidu.tbadk.mvc.b.a Jm2 = bVar.Jm();
            if (Jm2 instanceof FeedData) {
                return b((FeedData) Jm2);
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

    public ViewEventCenter JT() {
        if (this.ezh == null) {
            this.ezh = new ViewEventCenter();
        }
        return this.ezh;
    }

    public void aNh() {
        this.ezf.aNh();
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        this.ezf.b(bVar);
    }

    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        this.ezf.a(aVar);
    }

    public void aNi() {
        this.ezf.aNi();
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
        this.ezf.d(getPageContext(), i);
    }
}
