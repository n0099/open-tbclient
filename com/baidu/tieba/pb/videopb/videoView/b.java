package com.baidu.tieba.pb.videopb.videoView;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.tbadkCore.data.p;
import com.baidu.tieba.view.SortSwitchButton;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes16.dex */
public class b {
    private int aXh;
    private int aXi;
    private View.OnClickListener erD;
    private SortSwitchButton.a kAr;
    private SortSwitchButton kKa;
    private n kKm;
    private TextView kYB;
    private TextView kYC;
    private View mRootView;
    private int kKk = 0;
    private int kYD = 0;
    private SortSwitchButton.a kEx = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean xL(int i) {
            if (b.this.kAr != null) {
                return b.this.kAr.xL(i);
            }
            return true;
        }
    };
    private View.OnClickListener kKp = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.erD != null) {
                b.this.erD.onClick(view);
            }
            if (j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.kYB) {
                        if (view == b.this.kYC) {
                            b.this.setSelection(1);
                            return;
                        }
                        return;
                    }
                    b.this.setSelection(0);
                }
            }
        }
    };
    private View.OnClickListener kKq = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.erD != null) {
                b.this.erD.onClick(view);
            }
        }
    };

    public void setSelection(int i) {
        this.kYD = i;
        if (i == 0) {
            this.kYB.setTypeface(Typeface.defaultFromStyle(1));
            this.kYC.setTypeface(Typeface.defaultFromStyle(0));
            this.kYB.setTextColor(this.aXh);
            this.kYC.setTextColor(this.aXi);
        } else if (i == 1) {
            this.kYB.setTypeface(Typeface.defaultFromStyle(0));
            this.kYC.setTypeface(Typeface.defaultFromStyle(1));
            this.kYB.setTextColor(this.aXi);
            this.kYC.setTextColor(this.aXh);
        }
    }

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.kYB = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.kYB.setOnClickListener(this.kKp);
            this.kYC = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.kYC.setOnClickListener(this.kKp);
            this.kKa = (SortSwitchButton) this.mRootView.findViewById(R.id.video_pb_sort_switch_btn);
            this.kKa.setOnSwitchChangeListener(this.kEx);
            this.kKa.changeState(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void tp(boolean z) {
        if (z) {
            setSelection(1);
        } else {
            setSelection(0);
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        this.aXh = ap.getColor(R.color.cp_cont_b);
        this.aXi = ap.getColor(R.color.cp_cont_j);
        setSelection(this.kYD);
        this.kKa.onChangeSkinType();
    }

    public void a(n nVar) {
        this.kKm = nVar;
        if (nVar != null) {
            if (nVar.UM == n.kxY) {
                this.kYB.setClickable(true);
                this.kYB.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.kYC.setVisibility(0);
                tp(nVar.kyd);
            }
            if (nVar.isDynamic) {
                this.kYC.setVisibility(8);
                this.kKa.setVisibility(8);
            } else {
                this.kYC.setVisibility(0);
                if (nVar.kye != null) {
                    this.kKa.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.kye.size()) {
                            i = 0;
                            break;
                        } else if (nVar.kye.get(i) != null && nVar.sortType == nVar.kye.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(nVar.kye, i);
                }
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void p(List<PbSortType> list, int i) {
        if (y.isEmpty(list)) {
            this.kKa.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            p pVar = new p();
            pVar.HQ(pbSortType.sort_type.intValue());
            pVar.QO(pbSortType.sort_name);
            arrayList.add(pVar);
        }
        this.kKa.setVisibility(0);
        this.kKa.setData(arrayList, i);
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.kAr = aVar;
    }

    public void X(View.OnClickListener onClickListener) {
        this.erD = onClickListener;
    }
}
