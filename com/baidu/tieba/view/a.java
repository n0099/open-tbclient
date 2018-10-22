package com.baidu.tieba.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private TextView aiy;
    private Context hDL;
    private LinearLayout hDM;
    private View hDN;
    private TextView hDO;
    private d hDP;
    private b hDQ;
    private List<C0292a> mItems;
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
        void hp(int i);
    }

    public a(Context context) {
        if (context != null) {
            this.hDL = context;
            this.view = LayoutInflater.from(context).inflate(e.h.bottom_up_list_dialog_view, (ViewGroup) null);
            this.hDM = (LinearLayout) this.view.findViewById(e.g.content_view);
            this.aiy = (TextView) this.view.findViewById(e.g.title);
            this.hDN = this.view.findViewById(e.g.title_divide_line);
            this.mItems = new ArrayList();
            this.hDO = (TextView) this.view.findViewById(e.g.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.hDL;
    }

    public ViewGroup ajx() {
        return this.hDM;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(d dVar) {
        this.hDP = dVar;
    }

    public d bKu() {
        return this.hDP;
    }

    public void eb(List<C0292a> list) {
        if (list != null) {
            this.mItems = list;
            this.hDM.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0292a c0292a = list.get(i2);
                    if (c0292a != null) {
                        this.hDM.addView(c0292a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hDQ = bVar;
    }

    public void onChangeSkinType() {
        al.j(this.aiy, e.d.cp_bg_line_d);
        al.h(this.aiy, e.d.cp_cont_j);
        al.j(this.hDN, e.d.cp_bg_line_c);
        al.i(this.hDO, e.f.bg_bottom_up_list_dialog_item);
        al.h(this.hDO, e.d.cp_cont_f);
        if (this.mItems != null) {
            for (C0292a c0292a : this.mItems) {
                c0292a.onChangeSkinType();
            }
        }
    }

    public View bKv() {
        if (!StringUtils.isNull(this.titleText)) {
            this.aiy.setText(this.titleText);
        } else {
            this.aiy.setVisibility(8);
        }
        if (this.hDQ != null) {
            this.hDO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hDQ.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0292a {
        private View ejh;
        private a hDS;
        private int hDT;
        private int hDU;
        private c hDV;
        private boolean hDW;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private String mText;
        private int mTextColor;
        private TextView mTextView;
        private View mView;

        public C0292a(a aVar) {
            this(null, aVar);
        }

        public C0292a(String str, a aVar) {
            this.mTextColor = e.f.person_more_pop_cancel_text_selector;
            this.hDT = e.f.person_more_pop_item_bg_selector;
            this.hDU = 17;
            this.hDW = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0292a.this.hDV != null) {
                        C0292a.this.hDV.onClick();
                    }
                    if (C0292a.this.hDS != null && C0292a.this.hDS.bKu() != null) {
                        C0292a.this.hDS.bKu().hp(C0292a.this.mId);
                    }
                }
            };
            this.mText = str;
            this.hDS = aVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public C0292a(int i, String str, a aVar) {
            this.mTextColor = e.f.person_more_pop_cancel_text_selector;
            this.hDT = e.f.person_more_pop_item_bg_selector;
            this.hDU = 17;
            this.hDW = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0292a.this.hDV != null) {
                        C0292a.this.hDV.onClick();
                    }
                    if (C0292a.this.hDS != null && C0292a.this.hDS.bKu() != null) {
                        C0292a.this.hDS.bKu().hp(C0292a.this.mId);
                    }
                }
            };
            this.mId = i;
            this.mText = str;
            this.hDS = aVar;
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
            this.hDV = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            al.i(this.mTextView, e.f.bg_bottom_up_list_dialog_item);
            al.h(this.mTextView, e.d.cp_cont_b);
            al.j(this.ejh, e.d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hDS != null && this.hDS.getContext() != null) {
                this.mView = LayoutInflater.from(this.hDS.getContext()).inflate(e.h.bottom_up_list_dialog_item, this.hDS.ajx(), false);
                this.mTextView = (TextView) this.mView.findViewById(e.g.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.hDU);
                this.ejh = this.mView.findViewById(e.g.divider_line);
                if (this.hDW) {
                    this.ejh.setVisibility(0);
                } else {
                    this.ejh.setVisibility(8);
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
