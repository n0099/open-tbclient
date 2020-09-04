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
    private TextView dSD;
    private Context efT;
    private LinearLayout efV;
    private View efW;
    private TextView efX;
    private d mGU;
    private b mGV;
    private boolean mGW;
    private List<C0825a> mItems;
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
            this.efT = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.efV = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.dSD = (TextView) this.view.findViewById(R.id.title);
            this.efW = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.efX = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.efT;
    }

    public ViewGroup getView() {
        return this.efV;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d dFh() {
        return this.mGU;
    }

    public void aT(List<C0825a> list) {
        if (list != null) {
            this.mItems = list;
            this.efV.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0825a c0825a = list.get(i2);
                    if (c0825a != null) {
                        this.efV.addView(c0825a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.mGV = bVar;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.view, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.dSD, R.drawable.bg_title_corner_dialog_item);
        ap.setViewTextColor(this.dSD, R.color.cp_cont_c);
        ap.setBackgroundColor(this.efW, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.efX, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.efX, R.color.cp_cont_j);
        if (this.mItems != null) {
            for (C0825a c0825a : this.mItems) {
                c0825a.onChangeSkinType();
            }
        }
        if (this.mGW) {
            if (!StringUtils.isNull(this.titleText) && this.dSD != null && (this.dSD.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.dSD.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (y.getCount(this.mItems) > 0) {
                C0825a c0825a2 = this.mItems.get(0);
                if (!c0825a2.mHa) {
                    c0825a2.mHa = true;
                    c0825a2.onChangeSkinType();
                }
            }
        }
    }

    public View bhw() {
        if (!StringUtils.isNull(this.titleText)) {
            this.dSD.setText(this.titleText);
            this.efW.setVisibility(0);
        } else {
            this.dSD.setVisibility(8);
            this.efW.setVisibility(8);
        }
        if (this.mGV != null) {
            this.efX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.mGV.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0825a {
        private View efE;
        private int efF;
        private int efG;
        private boolean efI;
        private a mGY;
        private c mGZ;
        public boolean mHa;
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
            this.efF = R.drawable.person_more_pop_item_bg_selector;
            this.efG = 17;
            this.efI = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0825a.this.mGZ != null) {
                        C0825a.this.mGZ.onClick();
                    }
                    if (C0825a.this.mGY != null && C0825a.this.mGY.dFh() != null) {
                        C0825a.this.mGY.dFh().k(C0825a.this.mId, view);
                    }
                }
            };
            this.mText = str;
            this.mGY = aVar;
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
            this.mGZ = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.mTextView != null) {
                if (this.mHa) {
                    ap.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    this.mTextView.setBackgroundDrawable(ap.nT(R.color.cp_bg_line_k));
                }
            }
            ap.setViewTextColor(this.mTextView, R.color.cp_cont_b);
            ap.setBackgroundColor(this.efE, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.mGY != null && this.mGY.getContext() != null) {
                this.mView = LayoutInflater.from(this.mGY.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.mGY.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.efG);
                this.efE = this.mView.findViewById(R.id.divider_line);
                if (this.efI) {
                    this.efE.setVisibility(0);
                } else {
                    this.efE.setVisibility(8);
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
