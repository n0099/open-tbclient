package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<C0431a> aPr;
    private TextView bCd;
    private Context bOf;
    private LinearLayout bOh;
    private View bOi;
    private TextView bOj;
    private d jGt;
    private b jGu;
    private boolean jGv;
    private String titleText;
    private View view;

    /* loaded from: classes.dex */
    public interface b {
        void onClick();
    }

    /* loaded from: classes.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes.dex */
    public interface d {
        void m(int i, View view);
    }

    public a(Context context) {
        if (context != null) {
            this.bOf = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.bOh = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.bCd = (TextView) this.view.findViewById(R.id.title);
            this.bOi = this.view.findViewById(R.id.title_divide_line);
            this.aPr = new ArrayList();
            this.bOj = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.bOf;
    }

    public ViewGroup agZ() {
        return this.bOh;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d cxQ() {
        return this.jGt;
    }

    public void W(List<C0431a> list) {
        if (list != null) {
            this.aPr = list;
            this.bOh.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0431a c0431a = list.get(i2);
                    if (c0431a != null) {
                        this.bOh.addView(c0431a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.jGu = bVar;
    }

    public void onChangeSkinType() {
        am.k(this.bCd, R.drawable.bg_title_corner_dialog_item);
        am.j(this.bCd, R.color.cp_cont_c);
        am.l(this.bOi, R.color.cp_bg_line_c);
        am.k(this.bOj, R.drawable.bg_bottom_up_list_dialog_item);
        am.j(this.bOj, R.color.cp_cont_j);
        if (this.aPr != null) {
            for (C0431a c0431a : this.aPr) {
                c0431a.onChangeSkinType();
            }
        }
        if (this.jGv) {
            if (!StringUtils.isNull(this.titleText) && this.bCd != null && (this.bCd.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.bCd.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (v.Z(this.aPr) > 0) {
                C0431a c0431a2 = this.aPr.get(0);
                if (!c0431a2.jGz) {
                    c0431a2.jGz = true;
                    c0431a2.onChangeSkinType();
                }
            }
        }
    }

    public View ahb() {
        if (!StringUtils.isNull(this.titleText)) {
            this.bCd.setText(this.titleText);
            this.bOi.setVisibility(0);
        } else {
            this.bCd.setVisibility(8);
            this.bOi.setVisibility(8);
        }
        if (this.jGu != null) {
            this.bOj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.jGu.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0431a {
        private String amD;
        private View bNS;
        private int bNT;
        private int bNU;
        private boolean bNW;
        private a jGx;
        private c jGy;
        public boolean jGz;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private int mTextColor;
        public TextView mTextView;
        private View mView;

        public C0431a(a aVar) {
            this(null, aVar);
        }

        public C0431a(String str, a aVar) {
            this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
            this.bNT = R.drawable.person_more_pop_item_bg_selector;
            this.bNU = 17;
            this.bNW = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0431a.this.jGy != null) {
                        C0431a.this.jGy.onClick();
                    }
                    if (C0431a.this.jGx != null && C0431a.this.jGx.cxQ() != null) {
                        C0431a.this.jGx.cxQ().m(C0431a.this.mId, view);
                    }
                }
            };
            this.amD = str;
            this.jGx = aVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.amD = str;
            this.mTextView.setText(this.amD);
        }

        public void a(c cVar) {
            this.jGy = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.jGz) {
                am.k(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
            } else {
                am.k(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            }
            am.j(this.mTextView, R.color.cp_cont_b);
            am.l(this.bNS, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.jGx != null && this.jGx.getContext() != null) {
                this.mView = LayoutInflater.from(this.jGx.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.jGx.agZ(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.amD);
                this.mTextView.setGravity(this.bNU);
                this.bNS = this.mView.findViewById(R.id.divider_line);
                if (this.bNW) {
                    this.bNS.setVisibility(0);
                } else {
                    this.bNS.setVisibility(8);
                }
                onChangeSkinType();
            }
        }

        private void initListener() {
            if (this.mTextView != null) {
                this.mTextView.setOnClickListener(this.mOnClickListener);
            }
        }
    }
}
