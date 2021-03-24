package com.baidu.tieba.mainentrance;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class SearchPageFocusBar extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f18797e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f18798f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f18799g;

    /* renamed from: h  reason: collision with root package name */
    public Context f18800h;
    public TextView i;

    public SearchPageFocusBar(Context context) {
        super(context);
        a(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        this.f18800h = context;
        LayoutInflater.from(context).inflate(R.layout.home_search_focusbar, this);
        this.f18797e = (RelativeLayout) findViewById(R.id.focusbar_container);
        TextView textView = (TextView) findViewById(R.id.focusbar_hint);
        this.i = textView;
        SkinManager.setViewTextColor(textView, R.color.CAM_X0108, 1);
        this.i.setVisibility(8);
        TextView textView2 = (TextView) findViewById(R.id.focusbar_show);
        this.f18798f = textView2;
        SkinManager.setViewTextColor(textView2, R.color.CAM_X0302, 1);
        this.f18798f.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof TextView) {
            String charSequence = ((TextView) view).getText().toString();
            if (StringUtils.isNull(charSequence)) {
                return;
            }
            this.f18799g.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f18799g.getPageActivity()).createNormalCfg(charSequence, FrsActivityConfig.FRS_FROM_SEARCH)));
        }
    }

    public SearchPageFocusBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, null);
    }

    public SearchPageFocusBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, null);
    }
}
