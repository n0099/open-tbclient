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
    private TextView amN;
    private Context hMG;
    private LinearLayout hMH;
    private View hMI;
    private TextView hMJ;
    private d hMK;
    private b hML;
    private List<C0334a> mItems;
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
        void hQ(int i);
    }

    public a(Context context) {
        if (context != null) {
            this.hMG = context;
            this.view = LayoutInflater.from(context).inflate(e.h.bottom_up_list_dialog_view, (ViewGroup) null);
            this.hMH = (LinearLayout) this.view.findViewById(e.g.content_view);
            this.amN = (TextView) this.view.findViewById(e.g.title);
            this.hMI = this.view.findViewById(e.g.title_divide_line);
            this.mItems = new ArrayList();
            this.hMJ = (TextView) this.view.findViewById(e.g.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.hMG;
    }

    public ViewGroup akg() {
        return this.hMH;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(d dVar) {
        this.hMK = dVar;
    }

    public d bLX() {
        return this.hMK;
    }

    public void ed(List<C0334a> list) {
        if (list != null) {
            this.mItems = list;
            this.hMH.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0334a c0334a = list.get(i2);
                    if (c0334a != null) {
                        this.hMH.addView(c0334a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hML = bVar;
    }

    public void onChangeSkinType() {
        al.j(this.amN, e.d.cp_bg_line_d);
        al.h(this.amN, e.d.cp_cont_j);
        al.j(this.hMI, e.d.cp_bg_line_c);
        al.i(this.hMJ, e.f.bg_bottom_up_list_dialog_item);
        al.h(this.hMJ, e.d.cp_cont_f);
        if (this.mItems != null) {
            for (C0334a c0334a : this.mItems) {
                c0334a.onChangeSkinType();
            }
        }
    }

    public View bLY() {
        if (!StringUtils.isNull(this.titleText)) {
            this.amN.setText(this.titleText);
        } else {
            this.amN.setVisibility(8);
        }
        if (this.hML != null) {
            this.hMJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hML.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0334a {
        private View erw;
        private a hMN;
        private int hMO;
        private int hMP;
        private c hMQ;
        private boolean hMR;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private String mText;
        private int mTextColor;
        private TextView mTextView;
        private View mView;

        public C0334a(a aVar) {
            this(null, aVar);
        }

        public C0334a(String str, a aVar) {
            this.mTextColor = e.f.person_more_pop_cancel_text_selector;
            this.hMO = e.f.person_more_pop_item_bg_selector;
            this.hMP = 17;
            this.hMR = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0334a.this.hMQ != null) {
                        C0334a.this.hMQ.onClick();
                    }
                    if (C0334a.this.hMN != null && C0334a.this.hMN.bLX() != null) {
                        C0334a.this.hMN.bLX().hQ(C0334a.this.mId);
                    }
                }
            };
            this.mText = str;
            this.hMN = aVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public C0334a(int i, String str, a aVar) {
            this.mTextColor = e.f.person_more_pop_cancel_text_selector;
            this.hMO = e.f.person_more_pop_item_bg_selector;
            this.hMP = 17;
            this.hMR = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0334a.this.hMQ != null) {
                        C0334a.this.hMQ.onClick();
                    }
                    if (C0334a.this.hMN != null && C0334a.this.hMN.bLX() != null) {
                        C0334a.this.hMN.bLX().hQ(C0334a.this.mId);
                    }
                }
            };
            this.mId = i;
            this.mText = str;
            this.hMN = aVar;
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
            this.hMQ = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            al.i(this.mTextView, e.f.bg_bottom_up_list_dialog_item);
            al.h(this.mTextView, e.d.cp_cont_b);
            al.j(this.erw, e.d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hMN != null && this.hMN.getContext() != null) {
                this.mView = LayoutInflater.from(this.hMN.getContext()).inflate(e.h.bottom_up_list_dialog_item, this.hMN.akg(), false);
                this.mTextView = (TextView) this.mView.findViewById(e.g.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.hMP);
                this.erw = this.mView.findViewById(e.g.divider_line);
                if (this.hMR) {
                    this.erw.setVisibility(0);
                } else {
                    this.erw.setVisibility(8);
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
