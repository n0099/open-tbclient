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
/* loaded from: classes2.dex */
public class a {
    private TextView dSz;
    private Context efP;
    private LinearLayout efR;
    private View efS;
    private TextView efT;
    private d mGC;
    private b mGD;
    private boolean mGE;
    private List<C0825a> mItems;
    private String titleText;
    private View view;

    /* loaded from: classes2.dex */
    public interface b {
        void onClick();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes2.dex */
    public interface d {
        void k(int i, View view);
    }

    public a(Context context) {
        if (context != null) {
            this.efP = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.efR = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.dSz = (TextView) this.view.findViewById(R.id.title);
            this.efS = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.efT = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.efP;
    }

    public ViewGroup getView() {
        return this.efR;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d dEY() {
        return this.mGC;
    }

    public void aT(List<C0825a> list) {
        if (list != null) {
            this.mItems = list;
            this.efR.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0825a c0825a = list.get(i2);
                    if (c0825a != null) {
                        this.efR.addView(c0825a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.mGD = bVar;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.view, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.dSz, R.drawable.bg_title_corner_dialog_item);
        ap.setViewTextColor(this.dSz, R.color.cp_cont_c);
        ap.setBackgroundColor(this.efS, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.efT, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.efT, R.color.cp_cont_j);
        if (this.mItems != null) {
            for (C0825a c0825a : this.mItems) {
                c0825a.onChangeSkinType();
            }
        }
        if (this.mGE) {
            if (!StringUtils.isNull(this.titleText) && this.dSz != null && (this.dSz.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.dSz.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (y.getCount(this.mItems) > 0) {
                C0825a c0825a2 = this.mItems.get(0);
                if (!c0825a2.mGI) {
                    c0825a2.mGI = true;
                    c0825a2.onChangeSkinType();
                }
            }
        }
    }

    public View bhw() {
        if (!StringUtils.isNull(this.titleText)) {
            this.dSz.setText(this.titleText);
            this.efS.setVisibility(0);
        } else {
            this.dSz.setVisibility(8);
            this.efS.setVisibility(8);
        }
        if (this.mGD != null) {
            this.efT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.mGD.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0825a {
        private View efA;
        private int efB;
        private int efC;
        private boolean efE;
        private a mGG;
        private c mGH;
        public boolean mGI;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private String mText;
        private int mTextColor;
        public TextView mTextView;
        private View mView;

        public C0825a(a aVar) {
            this(null, aVar);
        }

        public C0825a(String str, a aVar) {
            this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
            this.efB = R.drawable.person_more_pop_item_bg_selector;
            this.efC = 17;
            this.efE = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0825a.this.mGH != null) {
                        C0825a.this.mGH.onClick();
                    }
                    if (C0825a.this.mGG != null && C0825a.this.mGG.dEY() != null) {
                        C0825a.this.mGG.dEY().k(C0825a.this.mId, view);
                    }
                }
            };
            this.mText = str;
            this.mGG = aVar;
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
            this.mGH = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.mTextView != null) {
                if (this.mGI) {
                    ap.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    this.mTextView.setBackgroundDrawable(ap.nT(R.color.cp_bg_line_k));
                }
            }
            ap.setViewTextColor(this.mTextView, R.color.cp_cont_b);
            ap.setBackgroundColor(this.efA, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.mGG != null && this.mGG.getContext() != null) {
                this.mView = LayoutInflater.from(this.mGG.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.mGG.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.efC);
                this.efA = this.mView.findViewById(R.id.divider_line);
                if (this.efE) {
                    this.efA.setVisibility(0);
                } else {
                    this.efA.setVisibility(8);
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
