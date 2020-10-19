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
    private TextView egP;
    private Context euq;
    private LinearLayout eus;
    private View eut;
    private TextView euu;
    private List<C0840a> mItems;
    private d ngk;
    private b ngl;
    private boolean ngm;
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
            this.euq = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.eus = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.egP = (TextView) this.view.findViewById(R.id.title);
            this.eut = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.euu = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.euq;
    }

    public ViewGroup getView() {
        return this.eus;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d dMN() {
        return this.ngk;
    }

    public void ba(List<C0840a> list) {
        if (list != null) {
            this.mItems = list;
            this.eus.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0840a c0840a = list.get(i2);
                    if (c0840a != null) {
                        this.eus.addView(c0840a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.ngl = bVar;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.view, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.egP, R.drawable.bg_title_corner_dialog_item);
        ap.setViewTextColor(this.egP, R.color.cp_cont_c);
        ap.setBackgroundColor(this.eut, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.euu, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.euu, R.color.cp_cont_j);
        if (this.mItems != null) {
            for (C0840a c0840a : this.mItems) {
                c0840a.onChangeSkinType();
            }
        }
        if (this.ngm) {
            if (!StringUtils.isNull(this.titleText) && this.egP != null && (this.egP.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.egP.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (y.getCount(this.mItems) > 0) {
                C0840a c0840a2 = this.mItems.get(0);
                if (!c0840a2.ngq) {
                    c0840a2.ngq = true;
                    c0840a2.onChangeSkinType();
                }
            }
        }
    }

    public View bkZ() {
        if (!StringUtils.isNull(this.titleText)) {
            this.egP.setText(this.titleText);
            this.eut.setVisibility(0);
        } else {
            this.egP.setVisibility(8);
            this.eut.setVisibility(8);
        }
        if (this.ngl != null) {
            this.euu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ngl.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0840a {
        private View eub;
        private int euc;
        private int eud;
        private boolean euf;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private String mText;
        private int mTextColor;
        public TextView mTextView;
        private View mView;
        private a ngo;
        private c ngp;
        public boolean ngq;

        public C0840a(a aVar) {
            this(null, aVar);
        }

        public C0840a(String str, a aVar) {
            this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
            this.euc = R.drawable.person_more_pop_item_bg_selector;
            this.eud = 17;
            this.euf = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0840a.this.ngp != null) {
                        C0840a.this.ngp.onClick();
                    }
                    if (C0840a.this.ngo != null && C0840a.this.ngo.dMN() != null) {
                        C0840a.this.ngo.dMN().k(C0840a.this.mId, view);
                    }
                }
            };
            this.mText = str;
            this.ngo = aVar;
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
            this.ngp = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.mTextView != null) {
                if (this.ngq) {
                    ap.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    this.mTextView.setBackgroundDrawable(ap.oC(R.color.cp_bg_line_k));
                }
            }
            ap.setViewTextColor(this.mTextView, R.color.cp_cont_b);
            ap.setBackgroundColor(this.eub, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.ngo != null && this.ngo.getContext() != null) {
                this.mView = LayoutInflater.from(this.ngo.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.ngo.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.eud);
                this.eub = this.mView.findViewById(R.id.divider_line);
                if (this.euf) {
                    this.eub.setVisibility(0);
                } else {
                    this.eub.setVisibility(8);
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
