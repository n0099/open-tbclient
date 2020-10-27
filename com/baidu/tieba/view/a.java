package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private Context eCP;
    private LinearLayout eCR;
    private View eCS;
    private TextView eCT;
    private TextView epn;
    private List<C0855a> mItems;
    private d nsL;
    private b nsM;
    private boolean nsN;
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
        void k(int i, View view);
    }

    public a(Context context) {
        if (context != null) {
            this.eCP = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.eCR = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.epn = (TextView) this.view.findViewById(R.id.title);
            this.eCS = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.eCT = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.eCP;
    }

    public ViewGroup getView() {
        return this.eCR;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d dPV() {
        return this.nsL;
    }

    public void bk(List<C0855a> list) {
        if (list != null) {
            this.mItems = list;
            this.eCR.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0855a c0855a = list.get(i2);
                    if (c0855a != null) {
                        this.eCR.addView(c0855a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.nsM = bVar;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.view, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.epn, R.drawable.bg_title_corner_dialog_item);
        ap.setViewTextColor(this.epn, R.color.cp_cont_c);
        ap.setBackgroundColor(this.eCS, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.eCT, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.eCT, R.color.cp_cont_j);
        if (this.mItems != null) {
            for (C0855a c0855a : this.mItems) {
                c0855a.onChangeSkinType();
            }
        }
        if (this.nsN) {
            if (!StringUtils.isNull(this.titleText) && this.epn != null && (this.epn.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.epn.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (y.getCount(this.mItems) > 0) {
                C0855a c0855a2 = this.mItems.get(0);
                if (!c0855a2.nsR) {
                    c0855a2.nsR = true;
                    c0855a2.onChangeSkinType();
                }
            }
        }
    }

    public View bmS() {
        if (!StringUtils.isNull(this.titleText)) {
            this.epn.setText(this.titleText);
            this.eCS.setVisibility(0);
        } else {
            this.epn.setVisibility(8);
            this.eCS.setVisibility(8);
        }
        if (this.nsM != null) {
            this.eCT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.nsM.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0855a {
        private View eCA;
        private int eCB;
        private int eCC;
        private boolean eCE;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private String mText;
        private int mTextColor;
        public TextView mTextView;
        private View mView;
        private a nsP;
        private c nsQ;
        public boolean nsR;

        public C0855a(a aVar) {
            this(null, aVar);
        }

        public C0855a(String str, a aVar) {
            this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
            this.eCB = R.drawable.person_more_pop_item_bg_selector;
            this.eCC = 17;
            this.eCE = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0855a.this.nsQ != null) {
                        C0855a.this.nsQ.onClick();
                    }
                    if (C0855a.this.nsP != null && C0855a.this.nsP.dPV() != null) {
                        C0855a.this.nsP.dPV().k(C0855a.this.mId, view);
                    }
                }
            };
            this.mText = str;
            this.nsP = aVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.mText = str;
            this.mTextView.setText(this.mText);
        }

        public void a(c cVar) {
            this.nsQ = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.mTextView != null) {
                if (this.nsR) {
                    ap.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    this.mTextView.setBackgroundDrawable(ap.oN(R.color.cp_bg_line_k));
                }
            }
            ap.setViewTextColor(this.mTextView, R.color.cp_cont_b);
            ap.setBackgroundColor(this.eCA, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.nsP != null && this.nsP.getContext() != null) {
                this.mView = LayoutInflater.from(this.nsP.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.nsP.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.eCC);
                this.eCA = this.mView.findViewById(R.id.divider_line);
                if (this.eCE) {
                    this.eCA.setVisibility(0);
                } else {
                    this.eCA.setVisibility(8);
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
