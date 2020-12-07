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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.l;
import com.baidu.tieba.personCenter.c.m;
/* loaded from: classes22.dex */
public class PersonCenterSmartAppItemView extends LinearLayout implements View.OnClickListener {
    private HeadImageView gui;
    private TextView mName;
    private ImageView mlo;
    private com.baidu.tieba.personCenter.c.c mlp;

    public PersonCenterSmartAppItemView(Context context) {
        this(context, null);
    }

    public PersonCenterSmartAppItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PersonCenterSmartAppItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.person_center_smart_app_item_layout, (ViewGroup) this, true);
        this.gui = (HeadImageView) findViewById(R.id.iv_person_center_smart_app_page_item_avatar);
        this.gui.setIsRound(true);
        this.gui.setDefaultResource(R.color.CAM_X0204);
        this.gui.setPlaceHolder(1);
        this.mName = (TextView) findViewById(R.id.tv_person_center_smart_app_page_item_name);
        this.mlo = (ImageView) findViewById(R.id.lv_person_center_smart_app_page_item_recommend);
        onChangeSkinType();
    }

    public void b(com.baidu.tieba.personCenter.c.c cVar) {
        if (cVar != null) {
            this.mlp = cVar;
            this.mlo.setVisibility(8);
            if (cVar instanceof m) {
                m mVar = (m) cVar;
                this.gui.startLoad(mVar.getAvatar(), 10, false, false);
                String name = mVar.getName();
                if (!au.isEmpty(name)) {
                    this.mName.setText(UtilHelper.getFixedText(name, 5));
                } else {
                    this.mName.setText(R.string.intelligent_smart_app);
                }
                if (cVar.getType() == 1) {
                    ap.setImageResource(this.mlo, R.drawable.icon_personal_recommend);
                    this.mlo.setVisibility(0);
                } else {
                    this.mlo.setVisibility(8);
                }
                setOnClickListener(this);
            } else if (cVar instanceof l) {
                ap.setImageResource(this.gui, R.drawable.icon_personal_more);
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
        if (this.mlp instanceof m) {
            m mVar = (m) this.mlp;
            if (!com.baidu.tieba.aiapps.a.b(mVar.getAppKey(), mVar.getLink(), "1191000600000000", mVar.dyA())) {
                if (!au.isEmpty(mVar.getH5Url())) {
                    bf.bua().b(X(getContext()), new String[]{mVar.getH5Url()});
                } else {
                    return;
                }
            }
            ar arVar = new ar("c13274");
            arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            arVar.dY("obj_source", "personal_center");
            arVar.w("obj_id", mVar.dyz().longValue());
            arVar.dY("obj_name", mVar.getName());
            arVar.al("obj_param1", mVar.dyA().intValue());
            TiebaStatic.log(arVar);
        } else if (this.mlp instanceof l) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SmartAppBrowseHistoryActivityConfig(getContext())));
            ar arVar2 = new ar("c13437");
            arVar2.w("uid", TbadkCoreApplication.getCurrentAccountId());
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

    private TbPageContext X(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }
}
