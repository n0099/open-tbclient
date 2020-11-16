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
/* loaded from: classes21.dex */
public class b {
    private int bdT;
    private int bdU;
    private View.OnClickListener eTp;
    private SortSwitchButton lAM;
    private n lAY;
    private TextView lPp;
    private TextView lPq;
    private SortSwitchButton.a lqV;
    private View mRootView;
    private int lAW = 0;
    private int lPr = 0;
    private SortSwitchButton.a lvf = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zU(int i) {
            if (b.this.lqV != null) {
                return b.this.lqV.zU(i);
            }
            return true;
        }
    };
    private View.OnClickListener lBb = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.eTp != null) {
                b.this.eTp.onClick(view);
            }
            if (j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.lPp) {
                        if (view == b.this.lPq) {
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
    private View.OnClickListener lBc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.eTp != null) {
                b.this.eTp.onClick(view);
            }
        }
    };

    public void setSelection(int i) {
        this.lPr = i;
        if (i == 0) {
            this.lPp.setTypeface(Typeface.defaultFromStyle(1));
            this.lPq.setTypeface(Typeface.defaultFromStyle(0));
            this.lPp.setTextColor(this.bdT);
            this.lPq.setTextColor(this.bdU);
        } else if (i == 1) {
            this.lPp.setTypeface(Typeface.defaultFromStyle(0));
            this.lPq.setTypeface(Typeface.defaultFromStyle(1));
            this.lPp.setTextColor(this.bdU);
            this.lPq.setTextColor(this.bdT);
        }
    }

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.lPp = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.lPp.setOnClickListener(this.lBb);
            this.lPq = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.lPq.setOnClickListener(this.lBb);
            this.lAM = (SortSwitchButton) this.mRootView.findViewById(R.id.video_pb_sort_switch_btn);
            this.lAM.setOnSwitchChangeListener(this.lvf);
            this.lAM.jL(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void uI(boolean z) {
        if (z) {
            setSelection(1);
        } else {
            setSelection(0);
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
        this.bdT = ap.getColor(R.color.CAM_X0105);
        this.bdU = ap.getColor(R.color.CAM_X0107);
        setSelection(this.lPr);
        this.lAM.onChangeSkinType();
    }

    public void a(n nVar) {
        this.lAY = nVar;
        if (nVar != null) {
            if (nVar.Vx == n.loE) {
                this.lPp.setClickable(true);
                this.lPp.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.lPq.setVisibility(0);
                uI(nVar.loJ);
            }
            if (nVar.isDynamic) {
                this.lPq.setVisibility(8);
                this.lAM.setVisibility(8);
            } else {
                this.lPq.setVisibility(0);
                if (nVar.loK != null) {
                    this.lAM.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.loK.size()) {
                            i = 0;
                            break;
                        } else if (nVar.loK.get(i) != null && nVar.sortType == nVar.loK.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(nVar.loK, i);
                }
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void p(List<PbSortType> list, int i) {
        if (y.isEmpty(list)) {
            this.lAM.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            p pVar = new p();
            pVar.Kg(pbSortType.sort_type.intValue());
            pVar.St(pbSortType.sort_name);
            arrayList.add(pVar);
        }
        this.lAM.setVisibility(0);
        this.lAM.setData(arrayList, i);
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lqV = aVar;
    }

    public void X(View.OnClickListener onClickListener) {
        this.eTp = onClickListener;
    }
}
