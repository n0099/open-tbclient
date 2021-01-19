package com.baidu.tieba.pb.videopb.videoView;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.tbadkCore.data.q;
import com.baidu.tieba.view.SortSwitchButton;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes2.dex */
public class b {
    private int bWL;
    private int bWM;
    private View.OnClickListener ffD;
    private SortSwitchButton.a lFo;
    private SortSwitchButton lPj;
    private n lPv;
    private View mRootView;
    private TextView meb;
    private TextView mec;
    private int lPt = 0;
    private int med = 0;
    private SortSwitchButton.a lJE = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zf(int i) {
            if (b.this.lFo != null) {
                return b.this.lFo.zf(i);
            }
            return true;
        }
    };
    private View.OnClickListener lPy = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.ffD != null) {
                b.this.ffD.onClick(view);
            }
            if (j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.meb) {
                        if (view == b.this.mec) {
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
    private View.OnClickListener lPz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.ffD != null) {
                b.this.ffD.onClick(view);
            }
        }
    };

    public void setSelection(int i) {
        this.med = i;
        if (i == 0) {
            this.meb.setTypeface(Typeface.defaultFromStyle(1));
            this.mec.setTypeface(Typeface.defaultFromStyle(0));
            this.meb.setTextColor(this.bWL);
            this.mec.setTextColor(this.bWM);
        } else if (i == 1) {
            this.meb.setTypeface(Typeface.defaultFromStyle(0));
            this.mec.setTypeface(Typeface.defaultFromStyle(1));
            this.meb.setTextColor(this.bWM);
            this.mec.setTextColor(this.bWL);
        }
    }

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.meb = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.meb.setOnClickListener(this.lPy);
            this.mec = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.mec.setOnClickListener(this.lPy);
            this.lPj = (SortSwitchButton) this.mRootView.findViewById(R.id.video_pb_sort_switch_btn);
            this.lPj.setOnSwitchChangeListener(this.lJE);
            this.lPj.iC(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void vh(boolean z) {
        if (z) {
            setSelection(1);
        } else {
            setSelection(0);
        }
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
        this.bWL = ao.getColor(R.color.CAM_X0105);
        this.bWM = ao.getColor(R.color.CAM_X0107);
        setSelection(this.med);
        this.lPj.onChangeSkinType();
    }

    public void a(n nVar) {
        this.lPv = nVar;
        if (nVar != null) {
            if (nVar.Wq == n.lCC) {
                this.meb.setClickable(true);
                this.meb.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.mec.setVisibility(0);
                vh(nVar.lCH);
            }
            if (nVar.isDynamic) {
                this.mec.setVisibility(8);
                this.lPj.setVisibility(8);
            } else {
                this.mec.setVisibility(0);
                if (nVar.lCI != null) {
                    this.lPj.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.lCI.size()) {
                            i = 0;
                            break;
                        } else if (nVar.lCI.get(i) != null && nVar.sortType == nVar.lCI.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(nVar.lCI, i);
                }
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void p(List<PbSortType> list, int i) {
        if (x.isEmpty(list)) {
            this.lPj.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            q qVar = new q();
            qVar.Jl(pbSortType.sort_type.intValue());
            qVar.Si(pbSortType.sort_name);
            arrayList.add(qVar);
        }
        this.lPj.setVisibility(0);
        this.lPj.setData(arrayList, i);
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lFo = aVar;
    }

    public void Z(View.OnClickListener onClickListener) {
        this.ffD = onClickListener;
    }
}
