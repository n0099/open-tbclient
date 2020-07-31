package com.baidu.tieba.personCenter.view;

import android.content.Context;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.l;
import com.baidu.tieba.personCenter.c.m;
/* loaded from: classes16.dex */
public class PersonCenterSmartAppItemView extends LinearLayout implements View.OnClickListener {
    private HeadImageView fvB;
    private ImageView kQp;
    private com.baidu.tieba.personCenter.c.c kQq;
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
        this.fvB = (HeadImageView) findViewById(R.id.iv_person_center_smart_app_page_item_avatar);
        this.fvB.setIsRound(true);
        this.fvB.setDefaultResource(R.color.cp_bg_line_c);
        this.fvB.setPlaceHolder(1);
        this.mName = (TextView) findViewById(R.id.tv_person_center_smart_app_page_item_name);
        this.kQp = (ImageView) findViewById(R.id.lv_person_center_smart_app_page_item_recommend);
        onChangeSkinType();
    }

    public void b(com.baidu.tieba.personCenter.c.c cVar) {
        if (cVar != null) {
            this.kQq = cVar;
            this.kQp.setVisibility(8);
            if (cVar instanceof m) {
                m mVar = (m) cVar;
                this.fvB.startLoad(mVar.getAvatar(), 10, false, false);
                String name = mVar.getName();
                if (!as.isEmpty(name)) {
                    this.mName.setText(UtilHelper.getFixedText(name, 5));
                } else {
                    this.mName.setText(R.string.intelligent_smart_app);
                }
                if (cVar.getType() == 1) {
                    ao.setImageResource(this.kQp, R.drawable.icon_personal_recommend);
                    this.kQp.setVisibility(0);
                } else {
                    this.kQp.setVisibility(8);
                }
                setOnClickListener(this);
            } else if (cVar instanceof l) {
                ao.setImageResource(this.fvB, R.drawable.icon_personal_more);
                this.mName.setText(R.string.more);
                setOnClickListener(this);
            }
        }
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.mName, R.color.cp_cont_b);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kQq instanceof m) {
            m mVar = (m) this.kQq;
            if (!com.baidu.tieba.aiapps.a.b(mVar.getAppKey(), mVar.getLink(), "1191000600000000", mVar.cVM())) {
                if (!as.isEmpty(mVar.getH5Url())) {
                    bd.baV().b(T(getContext()), new String[]{mVar.getH5Url()});
                } else {
                    return;
                }
            }
            ap apVar = new ap("c13274");
            apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
            apVar.dn("obj_source", "personal_center");
            apVar.t("obj_id", mVar.cVL().longValue());
            apVar.dn("obj_name", mVar.getName());
            apVar.ah("obj_param1", mVar.cVM().intValue());
            TiebaStatic.log(apVar);
        } else if (this.kQq instanceof l) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SmartAppBrowseHistoryActivityConfig(getContext())));
            ap apVar2 = new ap("c13437");
            apVar2.t("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(apVar2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                ao.setBackgroundColor(this, R.color.cp_bg_line_d_alpha50);
                ao.setViewTextColor(this.mName, R.color.cp_cont_b_alpha50);
                break;
            case 1:
                ao.setBackgroundColor(this, R.color.cp_bg_line_d);
                ao.setViewTextColor(this.mName, R.color.cp_cont_b);
                break;
            case 3:
                ao.setBackgroundColor(this, R.color.cp_bg_line_d);
                ao.setViewTextColor(this.mName, R.color.cp_cont_b);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private TbPageContext T(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }
}
