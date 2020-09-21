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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.l;
import com.baidu.tieba.personCenter.c.m;
/* loaded from: classes21.dex */
public class PersonCenterSmartAppItemView extends LinearLayout implements View.OnClickListener {
    private HeadImageView fKj;
    private ImageView lpj;
    private com.baidu.tieba.personCenter.c.c lpk;
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
        this.fKj = (HeadImageView) findViewById(R.id.iv_person_center_smart_app_page_item_avatar);
        this.fKj.setIsRound(true);
        this.fKj.setDefaultResource(R.color.cp_bg_line_c);
        this.fKj.setPlaceHolder(1);
        this.mName = (TextView) findViewById(R.id.tv_person_center_smart_app_page_item_name);
        this.lpj = (ImageView) findViewById(R.id.lv_person_center_smart_app_page_item_recommend);
        onChangeSkinType();
    }

    public void b(com.baidu.tieba.personCenter.c.c cVar) {
        if (cVar != null) {
            this.lpk = cVar;
            this.lpj.setVisibility(8);
            if (cVar instanceof m) {
                m mVar = (m) cVar;
                this.fKj.startLoad(mVar.getAvatar(), 10, false, false);
                String name = mVar.getName();
                if (!at.isEmpty(name)) {
                    this.mName.setText(UtilHelper.getFixedText(name, 5));
                } else {
                    this.mName.setText(R.string.intelligent_smart_app);
                }
                if (cVar.getType() == 1) {
                    ap.setImageResource(this.lpj, R.drawable.icon_personal_recommend);
                    this.lpj.setVisibility(0);
                } else {
                    this.lpj.setVisibility(8);
                }
                setOnClickListener(this);
            } else if (cVar instanceof l) {
                ap.setImageResource(this.fKj, R.drawable.icon_personal_more);
                this.mName.setText(R.string.more);
                setOnClickListener(this);
            }
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mName, R.color.cp_cont_b);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lpk instanceof m) {
            m mVar = (m) this.lpk;
            if (!com.baidu.tieba.aiapps.a.b(mVar.getAppKey(), mVar.getLink(), "1191000600000000", mVar.dkp())) {
                if (!at.isEmpty(mVar.getH5Url())) {
                    be.bkp().b(W(getContext()), new String[]{mVar.getH5Url()});
                } else {
                    return;
                }
            }
            aq aqVar = new aq("c13274");
            aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
            aqVar.dF("obj_source", "personal_center");
            aqVar.u("obj_id", mVar.dko().longValue());
            aqVar.dF("obj_name", mVar.getName());
            aqVar.ai("obj_param1", mVar.dkp().intValue());
            TiebaStatic.log(aqVar);
        } else if (this.lpk instanceof l) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SmartAppBrowseHistoryActivityConfig(getContext())));
            aq aqVar2 = new aq("c13437");
            aqVar2.u("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(aqVar2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                ap.setBackgroundColor(this, R.color.cp_bg_line_d_alpha50);
                ap.setViewTextColor(this.mName, R.color.cp_cont_b_alpha50);
                break;
            case 1:
                ap.setBackgroundColor(this, R.color.cp_bg_line_d);
                ap.setViewTextColor(this.mName, R.color.cp_cont_b);
                break;
            case 3:
                ap.setBackgroundColor(this, R.color.cp_bg_line_d);
                ap.setViewTextColor(this.mName, R.color.cp_cont_b);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private TbPageContext W(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }
}
