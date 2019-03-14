package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import com.tencent.connect.common.Constants;
/* loaded from: classes6.dex */
public class PersonCommonForumItemView extends RelativeLayout {
    public TextView eEk;
    public BarImageView hTM;
    public TextView hTN;
    public TextView hTO;
    public TextView hTP;
    private com.baidu.tieba.personPolymeric.c.f hTQ;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public PersonCommonForumItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(d.h.person_info_common_forum_item, (ViewGroup) this, true);
        init();
        initListener();
    }

    private void init() {
        this.hTM = (BarImageView) findViewById(d.g.forum_avatar);
        this.eEk = (TextView) findViewById(d.g.forum_name);
        this.hTN = (TextView) findViewById(d.g.forum_post_thread);
        this.hTO = (TextView) findViewById(d.g.forum_thread_num);
        this.hTP = (TextView) findViewById(d.g.forum_thread_str);
    }

    private void initListener() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.PersonCommonForumItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PersonCommonForumItemView.this.hTQ != null) {
                    TiebaStatic.log(new am("c12503").bJ("obj_locate", Constants.VIA_SHARE_TYPE_INFO));
                    TiebaStatic.log(new am("c11594"));
                    String str = PersonCommonForumItemView.this.hTQ.forumName;
                    if (ap.bv(str)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PersonCommonForumItemView.this.mContext).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(8)));
                    }
                }
            }
        };
    }

    public void setData(com.baidu.tieba.personPolymeric.c.f fVar) {
        this.hTQ = fVar;
        this.hTM.startLoad(fVar.avatar, 10, false);
        this.eEk.setText(ap.h(fVar.forumName, 7, "...") + this.mContext.getString(d.j.forum));
        this.hTO.setText(ap.as(fVar.hSc));
        this.hTN.setText(String.format(this.mContext.getString(d.j.person_has_posted), ap.hy(fVar.sex)));
        if (getRootView() != null) {
            getRootView().setOnClickListener(this.mOnClickListener);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            al.j(this.eEk, d.C0277d.cp_cont_b);
            al.j(this.hTN, d.C0277d.cp_cont_d);
            al.j(this.hTP, d.C0277d.cp_cont_d);
            al.j(this.hTO, d.C0277d.cp_link_tip_a);
            al.k(this, d.f.person_common_forum_item_bg);
        }
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }
}
