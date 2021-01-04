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
    private int cby;
    private int cbz;
    private View.OnClickListener fko;
    private SortSwitchButton.a lJT;
    private SortSwitchButton lTO;
    private n lUa;
    private View mRootView;
    private TextView miJ;
    private TextView miK;
    private int lTY = 0;
    private int miL = 0;
    private SortSwitchButton.a lOj = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean AL(int i) {
            if (b.this.lJT != null) {
                return b.this.lJT.AL(i);
            }
            return true;
        }
    };
    private View.OnClickListener lUd = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fko != null) {
                b.this.fko.onClick(view);
            }
            if (j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.miJ) {
                        if (view == b.this.miK) {
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
    private View.OnClickListener lUe = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fko != null) {
                b.this.fko.onClick(view);
            }
        }
    };

    public void setSelection(int i) {
        this.miL = i;
        if (i == 0) {
            this.miJ.setTypeface(Typeface.defaultFromStyle(1));
            this.miK.setTypeface(Typeface.defaultFromStyle(0));
            this.miJ.setTextColor(this.cby);
            this.miK.setTextColor(this.cbz);
        } else if (i == 1) {
            this.miJ.setTypeface(Typeface.defaultFromStyle(0));
            this.miK.setTypeface(Typeface.defaultFromStyle(1));
            this.miJ.setTextColor(this.cbz);
            this.miK.setTextColor(this.cby);
        }
    }

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.miJ = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.miJ.setOnClickListener(this.lUd);
            this.miK = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.miK.setOnClickListener(this.lUd);
            this.lTO = (SortSwitchButton) this.mRootView.findViewById(R.id.video_pb_sort_switch_btn);
            this.lTO.setOnSwitchChangeListener(this.lOj);
            this.lTO.ki(2);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void vl(boolean z) {
        if (z) {
            setSelection(1);
        } else {
            setSelection(0);
        }
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
        this.cby = ao.getColor(R.color.CAM_X0105);
        this.cbz = ao.getColor(R.color.CAM_X0107);
        setSelection(this.miL);
        this.lTO.onChangeSkinType();
    }

    public void a(n nVar) {
        this.lUa = nVar;
        if (nVar != null) {
            if (nVar.Ws == n.lHi) {
                this.miJ.setClickable(true);
                this.miJ.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.miK.setVisibility(0);
                vl(nVar.lHn);
            }
            if (nVar.isDynamic) {
                this.miK.setVisibility(8);
                this.lTO.setVisibility(8);
            } else {
                this.miK.setVisibility(0);
                if (nVar.lHo != null) {
                    this.lTO.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= nVar.lHo.size()) {
                            i = 0;
                            break;
                        } else if (nVar.lHo.get(i) != null && nVar.sortType == nVar.lHo.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    p(nVar.lHo, i);
                }
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void p(List<PbSortType> list, int i) {
        if (x.isEmpty(list)) {
            this.lTO.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            q qVar = new q();
            qVar.KS(pbSortType.sort_type.intValue());
            qVar.Tq(pbSortType.sort_name);
            arrayList.add(qVar);
        }
        this.lTO.setVisibility(0);
        this.lTO.setData(arrayList, i);
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lJT = aVar;
    }

    public void Z(View.OnClickListener onClickListener) {
        this.fko = onClickListener;
    }
}
