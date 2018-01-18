package com.baidu.tieba.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private TextView aGI;
    private List<a> aPZ;
    private Context hyj;
    private LinearLayout hyk;
    private View hyl;
    private TextView hym;
    private d hyn;
    private b hyo;
    private String titleText;
    private View view;

    /* loaded from: classes.dex */
    public interface b {
        void onClick();
    }

    /* renamed from: com.baidu.tieba.view.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0167c {
        void onClick();
    }

    /* loaded from: classes.dex */
    public interface d {
        void lG(int i);
    }

    public c(Context context) {
        if (context != null) {
            this.hyj = context;
            this.view = LayoutInflater.from(context).inflate(d.h.bottom_up_list_dialog_view, (ViewGroup) null);
            this.hyk = (LinearLayout) this.view.findViewById(d.g.content_view);
            this.aGI = (TextView) this.view.findViewById(d.g.title);
            this.hyl = this.view.findViewById(d.g.title_divide_line);
            this.aPZ = new ArrayList();
            this.hym = (TextView) this.view.findViewById(d.g.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.hyj;
    }

    public ViewGroup ael() {
        return this.hyk;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(d dVar) {
        this.hyn = dVar;
    }

    public d bDS() {
        return this.hyn;
    }

    public void dI(List<a> list) {
        if (list != null) {
            this.aPZ = list;
            this.hyk.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.hyk.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hyo = bVar;
    }

    public void onChangeSkinType() {
        aj.t(this.aGI, d.C0107d.cp_bg_line_d);
        aj.r(this.aGI, d.C0107d.cp_cont_j);
        aj.t(this.hyl, d.C0107d.cp_bg_line_c);
        aj.s(this.hym, d.f.bg_bottom_up_list_dialog_item);
        aj.r(this.hym, d.C0107d.cp_cont_f);
        if (this.aPZ != null) {
            for (a aVar : this.aPZ) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bDT() {
        if (!StringUtils.isNull(this.titleText)) {
            this.aGI.setText(this.titleText);
        } else {
            this.aGI.setVisibility(8);
        }
        if (this.hyo != null) {
            this.hym.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.hyo.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private String aTp;
        private View ecs;
        private c hyq;
        private int hyr;
        private int hys;
        private InterfaceC0167c hyt;
        private boolean hyu;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private int mTextColor;
        private View mView;
        private TextView rz;

        public a(c cVar) {
            this(null, cVar);
        }

        public a(String str, c cVar) {
            this.mTextColor = d.f.person_more_pop_cancel_text_selector;
            this.hyr = d.f.person_more_pop_item_bg_selector;
            this.hys = 17;
            this.hyu = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hyt != null) {
                        a.this.hyt.onClick();
                    }
                    if (a.this.hyq != null && a.this.hyq.bDS() != null) {
                        a.this.hyq.bDS().lG(a.this.mId);
                    }
                }
            };
            this.aTp = str;
            this.hyq = cVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public a(int i, String str, c cVar) {
            this.mTextColor = d.f.person_more_pop_cancel_text_selector;
            this.hyr = d.f.person_more_pop_item_bg_selector;
            this.hys = 17;
            this.hyu = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hyt != null) {
                        a.this.hyt.onClick();
                    }
                    if (a.this.hyq != null && a.this.hyq.bDS() != null) {
                        a.this.hyq.bDS().lG(a.this.mId);
                    }
                }
            };
            this.mId = i;
            this.aTp = str;
            this.hyq = cVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.aTp = str;
            this.rz.setText(this.aTp);
        }

        public void a(InterfaceC0167c interfaceC0167c) {
            this.hyt = interfaceC0167c;
            initListener();
        }

        public void onChangeSkinType() {
            aj.s(this.rz, d.f.bg_bottom_up_list_dialog_item);
            aj.r(this.rz, d.C0107d.cp_cont_b);
            aj.t(this.ecs, d.C0107d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hyq != null && this.hyq.getContext() != null) {
                this.mView = LayoutInflater.from(this.hyq.getContext()).inflate(d.h.bottom_up_list_dialog_item, this.hyq.ael(), false);
                this.rz = (TextView) this.mView.findViewById(d.g.item_view);
                this.rz.setText(this.aTp);
                this.rz.setGravity(this.hys);
                this.ecs = this.mView.findViewById(d.g.divider_line);
                if (this.hyu) {
                    this.ecs.setVisibility(0);
                } else {
                    this.ecs.setVisibility(8);
                }
                onChangeSkinType();
            }
        }

        private void initListener() {
            if (this.rz != null) {
                this.rz.setOnClickListener(this.mOnClickListener);
            }
        }
    }
}
