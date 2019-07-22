package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.SmartAppBrowseHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.data.k;
import com.baidu.tieba.personCenter.data.l;
/* loaded from: classes4.dex */
public class PersonCenterSmartAppItemView extends LinearLayout implements View.OnClickListener {
    private HeadImageView dpU;
    private ImageView ilc;
    private com.baidu.tieba.personCenter.data.c ild;
    private TextView mName;

    public PersonCenterSmartAppItemView(Context context) {
        this(context, null);
    }

    public PersonCenterSmartAppItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PersonCenterSmartAppItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.person_center_smart_app_item_layout, (ViewGroup) this, true);
        this.dpU = (HeadImageView) findViewById(R.id.iv_person_center_smart_app_page_item_avatar);
        this.dpU.setIsRound(true);
        this.dpU.setBg(new ColorDrawable(am.getColor(R.color.cp_bg_line_c)));
        this.mName = (TextView) findViewById(R.id.tv_person_center_smart_app_page_item_name);
        this.ilc = (ImageView) findViewById(R.id.lv_person_center_smart_app_page_item_recommend);
        onChangeSkinType();
    }

    public void b(com.baidu.tieba.personCenter.data.c cVar) {
        if (cVar != null) {
            this.ild = cVar;
            this.ilc.setVisibility(8);
            if (cVar instanceof l) {
                l lVar = (l) cVar;
                this.dpU.startLoad(lVar.getAvatar(), 10, false, false);
                String name = lVar.getName();
                if (!aq.isEmpty(name)) {
                    this.mName.setText(UtilHelper.getFixedText(name, 5));
                } else {
                    this.mName.setText(R.string.intelligent_smart_app);
                }
                if (cVar.getType() == 1) {
                    am.c(this.ilc, (int) R.drawable.icon_personal_recommend);
                    this.ilc.setVisibility(0);
                } else {
                    this.ilc.setVisibility(8);
                }
                setOnClickListener(this);
            } else if (cVar instanceof k) {
                am.c(this.dpU, (int) R.drawable.icon_personal_more);
                this.mName.setText(R.string.more);
                setOnClickListener(this);
            }
        }
    }

    public void onChangeSkinType() {
        am.l(this, R.color.cp_bg_line_d);
        am.j(this.mName, R.color.cp_cont_b);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ild instanceof l) {
            l lVar = (l) this.ild;
            if (!com.baidu.tieba.aiapps.a.b(lVar.getAppKey(), lVar.getLink(), "1191000600000000", lVar.cbl())) {
                if (!aq.isEmpty(lVar.alT())) {
                    bb.ajC().c(cH(getContext()), new String[]{lVar.alT()});
                } else {
                    return;
                }
            }
            an anVar = new an("c13274");
            anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "personal_center");
            anVar.l(VideoPlayActivityConfig.OBJ_ID, lVar.cbk().longValue());
            anVar.bT("obj_name", lVar.getName());
            anVar.P("obj_param1", lVar.cbl().intValue());
            TiebaStatic.log(anVar);
        } else if (this.ild instanceof k) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SmartAppBrowseHistoryActivityConfig(getContext())));
            an anVar2 = new an("c13437");
            anVar2.l("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(anVar2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                am.l(this, R.color.cp_bg_line_d_alpha50);
                am.j(this.mName, R.color.cp_cont_b_alpha50);
                break;
            case 1:
                am.l(this, R.color.cp_bg_line_d);
                am.j(this.mName, R.color.cp_cont_b);
                break;
            case 3:
                am.l(this, R.color.cp_bg_line_d);
                am.j(this.mName, R.color.cp_cont_b);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private TbPageContext cH(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }
}
