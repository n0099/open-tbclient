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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.l;
import com.baidu.tieba.personCenter.c.m;
/* loaded from: classes9.dex */
public class PersonCenterSmartAppItemView extends LinearLayout implements View.OnClickListener {
    private HeadImageView fqr;
    private ImageView kHp;
    private com.baidu.tieba.personCenter.c.c kHq;
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
        this.fqr = (HeadImageView) findViewById(R.id.iv_person_center_smart_app_page_item_avatar);
        this.fqr.setIsRound(true);
        this.fqr.setDefaultResource(R.color.cp_bg_line_c);
        this.fqr.setPlaceHolder(1);
        this.mName = (TextView) findViewById(R.id.tv_person_center_smart_app_page_item_name);
        this.kHp = (ImageView) findViewById(R.id.lv_person_center_smart_app_page_item_recommend);
        onChangeSkinType();
    }

    public void b(com.baidu.tieba.personCenter.c.c cVar) {
        if (cVar != null) {
            this.kHq = cVar;
            this.kHp.setVisibility(8);
            if (cVar instanceof m) {
                m mVar = (m) cVar;
                this.fqr.startLoad(mVar.getAvatar(), 10, false, false);
                String name = mVar.getName();
                if (!ar.isEmpty(name)) {
                    this.mName.setText(UtilHelper.getFixedText(name, 5));
                } else {
                    this.mName.setText(R.string.intelligent_smart_app);
                }
                if (cVar.getType() == 1) {
                    an.setImageResource(this.kHp, R.drawable.icon_personal_recommend);
                    this.kHp.setVisibility(0);
                } else {
                    this.kHp.setVisibility(8);
                }
                setOnClickListener(this);
            } else if (cVar instanceof l) {
                an.setImageResource(this.fqr, R.drawable.icon_personal_more);
                this.mName.setText(R.string.more);
                setOnClickListener(this);
            }
        }
    }

    public void onChangeSkinType() {
        an.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kHq instanceof m) {
            m mVar = (m) this.kHq;
            if (!com.baidu.tieba.aiapps.a.b(mVar.getAppKey(), mVar.getLink(), "1191000600000000", mVar.cRV())) {
                if (!ar.isEmpty(mVar.getH5Url())) {
                    bc.aWU().b(T(getContext()), new String[]{mVar.getH5Url()});
                } else {
                    return;
                }
            }
            ao aoVar = new ao("c13274");
            aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            aoVar.dk("obj_source", "personal_center");
            aoVar.s("obj_id", mVar.cRU().longValue());
            aoVar.dk("obj_name", mVar.getName());
            aoVar.ag("obj_param1", mVar.cRV().intValue());
            TiebaStatic.log(aoVar);
        } else if (this.kHq instanceof l) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SmartAppBrowseHistoryActivityConfig(getContext())));
            ao aoVar2 = new ao("c13437");
            aoVar2.s("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(aoVar2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                an.setBackgroundColor(this, R.color.cp_bg_line_d_alpha50);
                an.setViewTextColor(this.mName, (int) R.color.cp_cont_b_alpha50);
                break;
            case 1:
                an.setBackgroundColor(this, R.color.cp_bg_line_d);
                an.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
                break;
            case 3:
                an.setBackgroundColor(this, R.color.cp_bg_line_d);
                an.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
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
