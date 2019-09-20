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
    private List<C0442a> aPP;
    private TextView bCB;
    private Context bOL;
    private LinearLayout bON;
    private View bOO;
    private TextView bOP;
    private d jJV;
    private b jJW;
    private boolean jJX;
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
            this.bOL = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.bON = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.bCB = (TextView) this.view.findViewById(R.id.title);
            this.bOO = this.view.findViewById(R.id.title_divide_line);
            this.aPP = new ArrayList();
            this.bOP = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.bOL;
    }

    public ViewGroup ahf() {
        return this.bON;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d cza() {
        return this.jJV;
    }

    public void W(List<C0442a> list) {
        if (list != null) {
            this.aPP = list;
            this.bON.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0442a c0442a = list.get(i2);
                    if (c0442a != null) {
                        this.bON.addView(c0442a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.jJW = bVar;
    }

    public void onChangeSkinType() {
        am.l(this.view, R.color.cp_bg_line_c);
        am.k(this.bCB, R.drawable.bg_title_corner_dialog_item);
        am.j(this.bCB, R.color.cp_cont_c);
        am.l(this.bOO, R.color.cp_bg_line_c);
        am.k(this.bOP, R.drawable.bg_bottom_up_list_dialog_item);
        am.j(this.bOP, R.color.cp_cont_j);
        if (this.aPP != null) {
            for (C0442a c0442a : this.aPP) {
                c0442a.onChangeSkinType();
            }
        }
        if (this.jJX) {
            if (!StringUtils.isNull(this.titleText) && this.bCB != null && (this.bCB.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.bCB.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (v.Z(this.aPP) > 0) {
                C0442a c0442a2 = this.aPP.get(0);
                if (!c0442a2.jKb) {
                    c0442a2.jKb = true;
                    c0442a2.onChangeSkinType();
                }
            }
        }
    }

    public View ahh() {
        if (!StringUtils.isNull(this.titleText)) {
            this.bCB.setText(this.titleText);
            this.bOO.setVisibility(0);
        } else {
            this.bCB.setVisibility(8);
            this.bOO.setVisibility(8);
        }
        if (this.jJW != null) {
            this.bOP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.jJW.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0442a {
        private String anb;
        private boolean bOA;
        private View bOw;
        private int bOx;
        private int bOy;
        private a jJZ;
        private c jKa;
        public boolean jKb;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private int mTextColor;
        public TextView mTextView;
        private View mView;

        public C0442a(a aVar) {
            this(null, aVar);
        }

        public C0442a(String str, a aVar) {
            this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
            this.bOx = R.drawable.person_more_pop_item_bg_selector;
            this.bOy = 17;
            this.bOA = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0442a.this.jKa != null) {
                        C0442a.this.jKa.onClick();
                    }
                    if (C0442a.this.jJZ != null && C0442a.this.jJZ.cza() != null) {
                        C0442a.this.jJZ.cza().m(C0442a.this.mId, view);
                    }
                }
            };
            this.anb = str;
            this.jJZ = aVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.anb = str;
            this.mTextView.setText(this.anb);
        }

        public void a(c cVar) {
            this.jKa = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.mTextView != null) {
                if (this.jKb) {
                    am.k(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    this.mTextView.setBackgroundDrawable(am.io(R.color.cp_bg_line_k));
                }
            }
            am.j(this.mTextView, R.color.cp_cont_b);
            am.l(this.bOw, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.jJZ != null && this.jJZ.getContext() != null) {
                this.mView = LayoutInflater.from(this.jJZ.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.jJZ.ahf(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.anb);
                this.mTextView.setGravity(this.bOy);
                this.bOw = this.mView.findViewById(R.id.divider_line);
                if (this.bOA) {
                    this.bOw.setVisibility(0);
                } else {
                    this.bOw.setVisibility(8);
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
