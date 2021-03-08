package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.l;
import com.baidu.tieba.personCenter.c.m;
/* loaded from: classes2.dex */
public class PersonCenterSmartAppItemView extends LinearLayout implements View.OnClickListener {
    private HeadImageView gFk;
    private TextView mName;
    private ImageView mxl;
    private com.baidu.tieba.personCenter.c.c mxm;

    public PersonCenterSmartAppItemView(Context context) {
        this(context, null);
    }

    public PersonCenterSmartAppItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PersonCenterSmartAppItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.person_center_smart_app_item_layout, (ViewGroup) this, true);
        this.gFk = (HeadImageView) findViewById(R.id.iv_person_center_smart_app_page_item_avatar);
        this.gFk.setIsRound(true);
        this.gFk.setDefaultResource(R.color.CAM_X0204);
        this.gFk.setPlaceHolder(1);
        this.mName = (TextView) findViewById(R.id.tv_person_center_smart_app_page_item_name);
        this.mxl = (ImageView) findViewById(R.id.lv_person_center_smart_app_page_item_recommend);
        onChangeSkinType();
    }

    public void b(com.baidu.tieba.personCenter.c.c cVar) {
        if (cVar != null) {
            this.mxm = cVar;
            this.mxl.setVisibility(8);
            if (cVar instanceof m) {
                m mVar = (m) cVar;
                this.gFk.startLoad(mVar.getAvatar(), 10, false, false);
                String name = mVar.getName();
                if (!au.isEmpty(name)) {
                    this.mName.setText(UtilHelper.getFixedText(name, 5));
                } else {
                    this.mName.setText(R.string.intelligent_smart_app);
                }
                if (cVar.getType() == 1) {
                    ap.setImageResource(this.mxl, R.drawable.icon_personal_recommend);
                    this.mxl.setVisibility(0);
                } else {
                    this.mxl.setVisibility(8);
                }
                setOnClickListener(this);
            } else if (cVar instanceof l) {
                ap.setImageResource(this.gFk, R.drawable.icon_personal_more);
                this.mName.setText(R.string.more);
                setOnClickListener(this);
            }
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mName, R.color.CAM_X0105);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mxm instanceof m) {
            m mVar = (m) this.mxm;
            if (!com.baidu.tieba.aiapps.a.b(mVar.getAppKey(), mVar.getLink(), "1191000600000000", mVar.dwY())) {
                if (!au.isEmpty(mVar.getH5Url())) {
                    bf.bsY().b(V(getContext()), new String[]{mVar.getH5Url()});
                } else {
                    return;
                }
            }
            ar arVar = new ar("c13274");
            arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
            arVar.dR("obj_source", "personal_center");
            arVar.v("obj_id", mVar.dwX().longValue());
            arVar.dR("obj_name", mVar.getName());
            arVar.aq("obj_param1", mVar.dwY().intValue());
            TiebaStatic.log(arVar);
        } else if (this.mxm instanceof l) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SmartAppBrowseHistoryActivityConfig(getContext())));
            ar arVar2 = new ar("c13437");
            arVar2.v("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(arVar2);
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
                ap.setBackgroundColor(this, R.color.CAM_X0201);
                ap.setViewTextColor(this.mName, R.color.CAM_X0105);
                break;
            case 3:
                ap.setBackgroundColor(this, R.color.CAM_X0201);
                ap.setViewTextColor(this.mName, R.color.CAM_X0105);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private TbPageContext V(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }
}
