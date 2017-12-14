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
public class b {
    private TextView Sf;
    private List<a> abD;
    private Context haA;
    private LinearLayout haB;
    private View haC;
    private c haF;
    private String titleText;
    private View view;
    private int haD = d.C0096d.cp_bg_line_d;
    private int titleColor = d.C0096d.cp_cont_d;
    private int haE = d.C0096d.cp_bg_line_a;

    /* renamed from: com.baidu.tieba.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0156b {
        void onClick();
    }

    /* loaded from: classes.dex */
    public interface c {
        void iF(int i);
    }

    public b(Context context) {
        if (context != null) {
            this.haA = context;
            this.view = LayoutInflater.from(context).inflate(d.h.bottom_up_list_dialog_view, (ViewGroup) null);
            this.haB = (LinearLayout) this.view.findViewById(d.g.content_view);
            this.Sf = (TextView) this.view.findViewById(d.g.title);
            this.haC = this.view.findViewById(d.g.title_divide_line);
            this.abD = new ArrayList();
        }
    }

    public Context getContext() {
        return this.haA;
    }

    public ViewGroup WP() {
        return this.haB;
    }

    public int bEH() {
        return this.haE;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(c cVar) {
        this.haF = cVar;
    }

    public c bEI() {
        return this.haF;
    }

    public void dT(List<a> list) {
        if (list != null) {
            this.abD = list;
            this.haB.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    a aVar = list.get(i2);
                    if (aVar != null) {
                        this.haB.addView(aVar.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void onChangeSkinType() {
        aj.k(this.Sf, this.haD);
        aj.i(this.Sf, this.titleColor);
        aj.k(this.haC, this.haE);
        if (this.abD != null) {
            for (a aVar : this.abD) {
                aVar.onChangeSkinType();
            }
        }
    }

    public View bEJ() {
        if (!StringUtils.isNull(this.titleText)) {
            this.Sf.setText(this.titleText);
        } else {
            this.Sf.setVisibility(8);
        }
        onChangeSkinType();
        return this.view;
    }

    /* loaded from: classes.dex */
    public static class a {
        private TextView abT;
        private String afc;
        private View doW;
        private b haG;
        private int haH;
        private int haI;
        private InterfaceC0156b haJ;
        private boolean haK;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private int mTextColor;
        private View mView;

        public a(b bVar) {
            this(null, bVar);
        }

        public a(String str, b bVar) {
            this.mTextColor = d.f.person_more_pop_cancel_text_selector;
            this.haH = d.f.person_more_pop_item_bg_selector;
            this.haI = 17;
            this.haK = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.haJ != null) {
                        a.this.haJ.onClick();
                    }
                    if (a.this.haG != null && a.this.haG.bEI() != null) {
                        a.this.haG.bEI().iF(a.this.mId);
                    }
                }
            };
            this.afc = str;
            this.haG = bVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public a(int i, String str, b bVar) {
            this.mTextColor = d.f.person_more_pop_cancel_text_selector;
            this.haH = d.f.person_more_pop_item_bg_selector;
            this.haI = 17;
            this.haK = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.haJ != null) {
                        a.this.haJ.onClick();
                    }
                    if (a.this.haG != null && a.this.haG.bEI() != null) {
                        a.this.haG.bEI().iF(a.this.mId);
                    }
                }
            };
            this.mId = i;
            this.afc = str;
            this.haG = bVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.afc = str;
            this.abT.setText(this.afc);
        }

        public void a(InterfaceC0156b interfaceC0156b) {
            this.haJ = interfaceC0156b;
            initListener();
        }

        public void onChangeSkinType() {
            aj.j(this.abT, this.haH);
            aj.i(this.abT, this.mTextColor);
            aj.k(this.doW, this.haG.bEH());
        }

        private void initView() {
            if (this.haG != null && this.haG.getContext() != null) {
                this.mView = LayoutInflater.from(this.haG.getContext()).inflate(d.h.bottom_up_list_dialog_item, this.haG.WP(), false);
                this.abT = (TextView) this.mView.findViewById(d.g.item_view);
                this.abT.setText(this.afc);
                this.abT.setGravity(this.haI);
                this.doW = this.mView.findViewById(d.g.divider_line);
                if (this.haK) {
                    this.doW.setVisibility(0);
                } else {
                    this.doW.setVisibility(8);
                }
                onChangeSkinType();
            }
        }

        private void initListener() {
            if (this.abT != null) {
                this.abT.setOnClickListener(this.mOnClickListener);
            }
        }
    }
}
