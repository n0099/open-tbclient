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
    private TextView eIY;
    private Context eXh;
    private LinearLayout eXj;
    private View eXm;
    private TextView eXn;
    private List<C0903a> mItems;
    private d nZe;
    private b nZf;
    private boolean nZg;
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
            this.eXh = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.eXj = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.eIY = (TextView) this.view.findViewById(R.id.title);
            this.eXm = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.eXn = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.eXh;
    }

    public ViewGroup getView() {
        return this.eXj;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d dWf() {
        return this.nZe;
    }

    public void bw(List<C0903a> list) {
        if (list != null) {
            this.mItems = list;
            this.eXj.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0903a c0903a = list.get(i2);
                    if (c0903a != null) {
                        this.eXj.addView(c0903a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.nZf = bVar;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.view, R.color.CAM_X0204);
        ap.setBackgroundResource(this.eIY, R.drawable.bg_title_corner_dialog_item);
        ap.setViewTextColor(this.eIY, R.color.CAM_X0108);
        ap.setBackgroundColor(this.eXm, R.color.CAM_X0204);
        ap.setBackgroundResource(this.eXn, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.eXn, R.color.CAM_X0107);
        if (this.mItems != null) {
            for (C0903a c0903a : this.mItems) {
                c0903a.onChangeSkinType();
            }
        }
        if (this.nZg) {
            if (!StringUtils.isNull(this.titleText) && this.eIY != null && (this.eIY.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.eIY.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (y.getCount(this.mItems) > 0) {
                C0903a c0903a2 = this.mItems.get(0);
                if (!c0903a2.nZk) {
                    c0903a2.nZk = true;
                    c0903a2.onChangeSkinType();
                }
            }
        }
    }

    public View bqS() {
        if (!StringUtils.isNull(this.titleText)) {
            this.eIY.setText(this.titleText);
            this.eXm.setVisibility(0);
        } else {
            this.eIY.setVisibility(8);
            this.eXm.setVisibility(8);
        }
        if (this.nZf != null) {
            this.eXn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.nZf.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0903a {
        private View eWL;
        private String mText;
        public TextView mTextView;
        private View mView;
        private a nZi;
        private c nZj;
        public boolean nZk;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int eWM = R.drawable.person_more_pop_item_bg_selector;
        private int eWN = 17;
        private boolean eWP = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (C0903a.this.nZj != null) {
                    C0903a.this.nZj.onClick();
                }
                if (C0903a.this.nZi != null && C0903a.this.nZi.dWf() != null) {
                    C0903a.this.nZi.dWf().k(C0903a.this.mId, view);
                }
            }
        };
        private int mId = hashCode();

        public C0903a(String str, a aVar) {
            this.mText = str;
            this.nZi = aVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.nZj = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.mTextView != null) {
                if (this.nZk) {
                    ap.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    this.mTextView.setBackgroundDrawable(ap.oD(R.color.CAM_X0211));
                }
            }
            ap.setViewTextColor(this.mTextView, R.color.CAM_X0105);
            ap.setBackgroundColor(this.eWL, R.color.CAM_X0204);
        }

        private void initView() {
            if (this.nZi != null && this.nZi.getContext() != null) {
                this.mView = LayoutInflater.from(this.nZi.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.nZi.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.eWN);
                this.eWL = this.mView.findViewById(R.id.divider_line);
                if (this.eWP) {
                    this.eWL.setVisibility(0);
                } else {
                    this.eWL.setVisibility(8);
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
