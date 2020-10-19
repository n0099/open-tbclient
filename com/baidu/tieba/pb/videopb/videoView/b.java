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
/* loaded from: classes22.dex */
public class b {
    private int bcX;
    private int bcY;
    private View.OnClickListener eFW;
    private SortSwitchButton.a kYg;
    private SortSwitchButton lhU;
    private n lig;
    private TextView lwF;
    private TextView lwG;
    private View mRootView;
    private int lie = 0;
    private int lwH = 0;
    private SortSwitchButton.a lcp = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean yQ(int i) {
            if (b.this.kYg != null) {
                return b.this.kYg.yQ(i);
            }
            return true;
        }
    };
    private View.OnClickListener lij = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.eFW != null) {
                b.this.eFW.onClick(view);
            }
            if (j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.lwF) {
                        if (view == b.this.lwG) {
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
    private View.OnClickListener lik = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.eFW != null) {
                b.this.eFW.onClick(view);
            }
        }
    };

    public void setSelection(int i) {
        this.lwH = i;
        if (i == 0) {
            this.lwF.setTypeface(Typeface.defaultFromStyle(1));
            this.lwG.setTypeface(Typeface.defaultFromStyle(0));
            this.lwF.setTextColor(this.bcX);
            this.lwG.setTextColor(this.bcY);
        } else if (i == 1) {
            this.lwF.setTypeface(Typeface.defaultFromStyle(0));
            this.lwG.setTypeface(Typeface.defaultFromStyle(1));
            this.lwF.setTextColor(this.bcY);
            this.lwG.setTextColor(this.bcX);
        }
    }

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.lwF = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.lwF.setOnClickListener(this.lij);
            this.lwG = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.lwG.setOnClickListener(this.lij);
            this.lhU = (SortSwitchButton) this.mRootView.findViewById(R.id.video_pb_sort_switch_btn);
            this.lhU.setOnSwitchChangeListener(this.lcp);
            this.lhU.ju(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void uf(boolean z) {
        if (z) {
            setSelection(1);
        } else {
            setSelection(0);
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        this.bcX = ap.getColor(R.color.cp_cont_b);
        this.bcY = ap.getColor(R.color.cp_cont_j);
        setSelection(this.lwH);
        this.lhU.onChangeSkinType();
    }

    public void a(n nVar) {
        this.lig = nVar;
        if (nVar != null) {
            if (nVar.Vv == n.kVN) {
                this.lwF.setClickable(true);
                this.lwF.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.lwG.setVisibility(0);
                uf(nVar.kVS);
            }
            if (nVar.isDynamic) {
                this.lwG.setVisibility(8);
                this.lhU.setVisibility(8);
            } else {
                this.lwG.setVisibility(0);
                if (nVar.kVT != null) {
                    this.lhU.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.kVT.size()) {
                            i = 0;
                            break;
                        } else if (nVar.kVT.get(i) != null && nVar.sortType == nVar.kVT.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(nVar.kVT, i);
                }
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void p(List<PbSortType> list, int i) {
        if (y.isEmpty(list)) {
            this.lhU.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            p pVar = new p();
            pVar.IZ(pbSortType.sort_type.intValue());
            pVar.Sc(pbSortType.sort_name);
            arrayList.add(pVar);
        }
        this.lhU.setVisibility(0);
        this.lhU.setData(arrayList, i);
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.kYg = aVar;
    }

    public void X(View.OnClickListener onClickListener) {
        this.eFW = onClickListener;
    }
}
