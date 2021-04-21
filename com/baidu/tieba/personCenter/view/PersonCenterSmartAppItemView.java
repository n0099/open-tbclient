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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SmartAppBrowseHistoryActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import d.b.c.e.p.k;
import d.b.j0.g2.e.c;
import d.b.j0.g2.e.l;
import d.b.j0.g2.e.m;
import d.b.j0.s.a;
/* loaded from: classes3.dex */
public class PersonCenterSmartAppItemView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f19965e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19966f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f19967g;

    /* renamed from: h  reason: collision with root package name */
    public c f19968h;

    public PersonCenterSmartAppItemView(Context context) {
        this(context, null);
    }

    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        this.f19968h = cVar;
        this.f19967g.setVisibility(8);
        if (cVar instanceof m) {
            m mVar = (m) cVar;
            this.f19965e.X(mVar.c(), 10, false, false);
            String g2 = mVar.g();
            if (!k.isEmpty(g2)) {
                this.f19966f.setText(UtilHelper.getFixedText(g2, 5));
            } else {
                this.f19966f.setText(R.string.intelligent_smart_app);
            }
            if (cVar.getType() == 1) {
                SkinManager.setImageResource(this.f19967g, R.drawable.icon_personal_recommend);
                this.f19967g.setVisibility(0);
            } else {
                this.f19967g.setVisibility(8);
            }
            setOnClickListener(this);
        } else if (cVar instanceof l) {
            SkinManager.setImageResource(this.f19965e, R.drawable.icon_personal_more);
            this.f19966f.setText(R.string.more);
            setOnClickListener(this);
        }
    }

    public final TbPageContext b(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }

    public void c() {
        SkinManager.setViewTextColor(this.f19966f, R.color.CAM_X0105);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c cVar = this.f19968h;
        if (cVar instanceof m) {
            m mVar = (m) cVar;
            if (!a.b(mVar.b(), mVar.f(), "1191000600000000", mVar.e())) {
                if (k.isEmpty(mVar.d())) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(b(getContext()), new String[]{mVar.d()});
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_source", "personal_center");
            statisticItem.param("obj_id", mVar.a().longValue());
            statisticItem.param("obj_name", mVar.g());
            statisticItem.param("obj_param1", mVar.e().intValue());
            TiebaStatic.log(statisticItem);
        } else if (cVar instanceof l) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SmartAppBrowseHistoryActivityConfig(getContext())));
            StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_MORE_HISTORY_RECORD_CLICK);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            SkinManager.setBackgroundColor(this, R.color.cp_bg_line_d_alpha50);
            SkinManager.setViewTextColor(this.f19966f, R.color.cp_cont_b_alpha50);
        } else if (action == 1) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f19966f, R.color.CAM_X0105);
        } else if (action == 3) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f19966f, R.color.CAM_X0105);
        }
        return super.onTouchEvent(motionEvent);
    }

    public PersonCenterSmartAppItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PersonCenterSmartAppItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.person_center_smart_app_item_layout, (ViewGroup) this, true);
        HeadImageView headImageView = (HeadImageView) findViewById(R.id.iv_person_center_smart_app_page_item_avatar);
        this.f19965e = headImageView;
        headImageView.setIsRound(true);
        this.f19965e.setDefaultResource(R.color.CAM_X0204);
        this.f19965e.setPlaceHolder(1);
        this.f19966f = (TextView) findViewById(R.id.tv_person_center_smart_app_page_item_name);
        this.f19967g = (ImageView) findViewById(R.id.lv_person_center_smart_app_page_item_recommend);
        c();
    }
}
