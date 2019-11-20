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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SmartAppBrowseHistoryActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.data.k;
import com.baidu.tieba.personCenter.data.l;
/* loaded from: classes4.dex */
public class PersonCenterSmartAppItemView extends LinearLayout implements View.OnClickListener {
    private HeadImageView dyf;
    private ImageView ilZ;
    private com.baidu.tieba.personCenter.data.c ima;
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
        this.dyf = (HeadImageView) findViewById(R.id.iv_person_center_smart_app_page_item_avatar);
        this.dyf.setIsRound(true);
        this.dyf.setBg(new ColorDrawable(am.getColor(R.color.cp_bg_line_c)));
        this.mName = (TextView) findViewById(R.id.tv_person_center_smart_app_page_item_name);
        this.ilZ = (ImageView) findViewById(R.id.lv_person_center_smart_app_page_item_recommend);
        onChangeSkinType();
    }

    public void b(com.baidu.tieba.personCenter.data.c cVar) {
        if (cVar != null) {
            this.ima = cVar;
            this.ilZ.setVisibility(8);
            if (cVar instanceof l) {
                l lVar = (l) cVar;
                this.dyf.startLoad(lVar.getAvatar(), 10, false, false);
                String name = lVar.getName();
                if (!aq.isEmpty(name)) {
                    this.mName.setText(UtilHelper.getFixedText(name, 5));
                } else {
                    this.mName.setText(R.string.intelligent_smart_app);
                }
                if (cVar.getType() == 1) {
                    am.setImageResource(this.ilZ, R.drawable.icon_personal_recommend);
                    this.ilZ.setVisibility(0);
                } else {
                    this.ilZ.setVisibility(8);
                }
                setOnClickListener(this);
            } else if (cVar instanceof k) {
                am.setImageResource(this.dyf, R.drawable.icon_personal_more);
                this.mName.setText(R.string.more);
                setOnClickListener(this);
            }
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ima instanceof l) {
            l lVar = (l) this.ima;
            if (!com.baidu.tieba.aiapps.a.b(lVar.getAppKey(), lVar.getLink(), "1191000600000000", lVar.bZr())) {
                if (!aq.isEmpty(lVar.getH5Url())) {
                    ba.amO().b(ct(getContext()), new String[]{lVar.getH5Url()});
                } else {
                    return;
                }
            }
            an anVar = new an("c13274");
            anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
            anVar.bS("obj_source", "personal_center");
            anVar.p("obj_id", lVar.bZq().longValue());
            anVar.bS("obj_name", lVar.getName());
            anVar.O("obj_param1", lVar.bZr().intValue());
            TiebaStatic.log(anVar);
        } else if (this.ima instanceof k) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SmartAppBrowseHistoryActivityConfig(getContext())));
            an anVar2 = new an("c13437");
            anVar2.p("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(anVar2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                am.setBackgroundColor(this, R.color.cp_bg_line_d_alpha50);
                am.setViewTextColor(this.mName, (int) R.color.cp_cont_b_alpha50);
                break;
            case 1:
                am.setBackgroundColor(this, R.color.cp_bg_line_d);
                am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
                break;
            case 3:
                am.setBackgroundColor(this, R.color.cp_bg_line_d);
                am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private TbPageContext ct(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }
}
