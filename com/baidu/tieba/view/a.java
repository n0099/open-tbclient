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
    private Context bOk;
    private LinearLayout bOm;
    private View bOn;
    private TextView bOo;
    private d jHA;
    private b jHB;
    private boolean jHC;
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
            this.bOk = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.bOm = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.bCd = (TextView) this.view.findViewById(R.id.title);
            this.bOn = this.view.findViewById(R.id.title_divide_line);
            this.aPr = new ArrayList();
            this.bOo = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.bOk;
    }

    public ViewGroup ahb() {
        return this.bOm;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d cym() {
        return this.jHA;
    }

    public void W(List<C0431a> list) {
        if (list != null) {
            this.aPr = list;
            this.bOm.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0431a c0431a = list.get(i2);
                    if (c0431a != null) {
                        this.bOm.addView(c0431a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.jHB = bVar;
    }

    public void onChangeSkinType() {
        am.k(this.bCd, R.drawable.bg_title_corner_dialog_item);
        am.j(this.bCd, R.color.cp_cont_c);
        am.l(this.bOn, R.color.cp_bg_line_c);
        am.k(this.bOo, R.drawable.bg_bottom_up_list_dialog_item);
        am.j(this.bOo, R.color.cp_cont_j);
        if (this.aPr != null) {
            for (C0431a c0431a : this.aPr) {
                c0431a.onChangeSkinType();
            }
        }
        if (this.jHC) {
            if (!StringUtils.isNull(this.titleText) && this.bCd != null && (this.bCd.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.bCd.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (v.Z(this.aPr) > 0) {
                C0431a c0431a2 = this.aPr.get(0);
                if (!c0431a2.jHG) {
                    c0431a2.jHG = true;
                    c0431a2.onChangeSkinType();
                }
            }
        }
    }

    public View ahd() {
        if (!StringUtils.isNull(this.titleText)) {
            this.bCd.setText(this.titleText);
            this.bOn.setVisibility(0);
        } else {
            this.bCd.setVisibility(8);
            this.bOn.setVisibility(8);
        }
        if (this.jHB != null) {
            this.bOo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.jHB.onClick();
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
        private View bNX;
        private int bNY;
        private int bNZ;
        private boolean bOb;
        private a jHE;
        private c jHF;
        public boolean jHG;
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
            this.bNY = R.drawable.person_more_pop_item_bg_selector;
            this.bNZ = 17;
            this.bOb = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0431a.this.jHF != null) {
                        C0431a.this.jHF.onClick();
                    }
                    if (C0431a.this.jHE != null && C0431a.this.jHE.cym() != null) {
                        C0431a.this.jHE.cym().m(C0431a.this.mId, view);
                    }
                }
            };
            this.amD = str;
            this.jHE = aVar;
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
            this.jHF = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.jHG) {
                am.k(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
            } else {
                am.k(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            }
            am.j(this.mTextView, R.color.cp_cont_b);
            am.l(this.bNX, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.jHE != null && this.jHE.getContext() != null) {
                this.mView = LayoutInflater.from(this.jHE.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.jHE.ahb(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.amD);
                this.mTextView.setGravity(this.bNZ);
                this.bNX = this.mView.findViewById(R.id.divider_line);
                if (this.bOb) {
                    this.bNX.setVisibility(0);
                } else {
                    this.bNX.setVisibility(8);
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
