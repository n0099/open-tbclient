package com.baidu.tieba.pb.videopb.videoView;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.tbadkCore.data.q;
import com.baidu.tieba.view.SortSwitchButton;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes9.dex */
public class b {
    private int aNV;
    private int aNW;
    private View.OnClickListener dUl;
    private SortSwitchButton.a jHF;
    private l jQL;
    private TextView jQy;
    private SortSwitchButton jQz;
    private TextView keQ;
    private TextView keR;
    private View mRootView;
    public boolean jQO = d.aMn();
    private int jQJ = 0;
    private int keS = 0;
    private SortSwitchButton.a jLw = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.videoView.b.1
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean ut(int i) {
            if (b.this.jHF != null) {
                return b.this.jHF.ut(i);
            }
            return true;
        }
    };
    private View.OnClickListener jQP = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dUl != null) {
                b.this.dUl.onClick(view);
            }
            if (j.isNetWorkAvailable()) {
                if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                    if (view != b.this.keQ) {
                        if (view == b.this.keR) {
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
    private View.OnClickListener jQQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.videoView.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.dUl != null) {
                b.this.dUl.onClick(view);
            }
        }
    };

    public void setSelection(int i) {
        this.keS = i;
        if (i == 0) {
            this.keQ.setTypeface(Typeface.defaultFromStyle(1));
            this.keR.setTypeface(Typeface.defaultFromStyle(0));
            this.keQ.setTextColor(this.aNV);
            this.keR.setTextColor(this.aNW);
        } else if (i == 1) {
            this.keQ.setTypeface(Typeface.defaultFromStyle(0));
            this.keR.setTypeface(Typeface.defaultFromStyle(1));
            this.keQ.setTextColor(this.aNW);
            this.keR.setTextColor(this.aNV);
        }
    }

    public b(View view) {
        if (view != null) {
            this.mRootView = view;
            this.keQ = (TextView) this.mRootView.findViewById(R.id.all_reply);
            this.keQ.setOnClickListener(this.jQP);
            this.keR = (TextView) this.mRootView.findViewById(R.id.owner_reply);
            this.keR.setOnClickListener(this.jQP);
            if (this.jQO) {
                this.jQz = (SortSwitchButton) this.mRootView.findViewById(R.id.video_pb_sort_switch_btn);
                this.jQz.setOnSwitchChangeListener(this.jLw);
            } else {
                this.jQy = (TextView) this.mRootView.findViewById(R.id.pb_sort_type);
                this.jQy.setOnClickListener(this.jQQ);
                this.jQy.setVisibility(0);
            }
            if (com.baidu.tbadk.util.a.bgh().aXE()) {
                if (this.jQO) {
                    this.jQz.changeState(2);
                } else {
                    bp(2, "");
                }
            } else if (this.jQO) {
                this.jQz.changeState(0);
            } else {
                bp(0, "");
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void rN(boolean z) {
        if (z) {
            setSelection(1);
        } else {
            setSelection(0);
        }
    }

    public void bp(int i, String str) {
        this.jQJ = i;
        this.jQy.setVisibility(0);
        if (str.length() > 0) {
            this.jQy.setText(str);
        } else if (this.jQJ == 0) {
            this.jQy.setText(R.string.sort_type_new);
        } else if (this.jQJ == 1) {
            this.jQy.setText(R.string.sort_type_old);
        } else if (this.jQJ == 2) {
            this.jQy.setText(R.string.sort_type_hot);
        }
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        this.aNV = am.getColor(R.color.cp_cont_b);
        this.aNW = am.getColor(R.color.cp_cont_j);
        setSelection(this.keS);
        if (this.jQO) {
            this.jQz.onChangeSkinType();
            return;
        }
        am.setViewTextColor(this.jQy, (int) R.color.cp_cont_j);
        this.jQy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.aUV().a(R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null);
    }

    public void a(l lVar) {
        this.jQL = lVar;
        if (lVar != null) {
            if (lVar.TK == l.jFi) {
                this.keQ.setClickable(true);
                this.keQ.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
                this.keR.setVisibility(0);
                rN(lVar.jFn);
            }
            if (lVar.isDynamic) {
                this.keR.setVisibility(8);
                if (this.jQO) {
                    this.jQz.setVisibility(8);
                } else {
                    this.jQy.setVisibility(8);
                }
            } else {
                this.keR.setVisibility(0);
                if (this.jQO) {
                    if (lVar.jFo != null) {
                        this.jQz.setVisibility(0);
                        int i = 0;
                        while (true) {
                            if (i >= lVar.jFo.size()) {
                                i = 0;
                                break;
                            } else if (lVar.jFo.get(i) != null && lVar.sortType == lVar.jFo.get(i).sort_type.intValue()) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        n(lVar.jFo, i);
                    }
                } else {
                    this.jQy.setVisibility(0);
                    bp(lVar.sortType, lVar.jFm);
                }
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void n(List<PbSortType> list, int i) {
        if (v.isEmpty(list)) {
            this.jQz.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PbSortType pbSortType : list) {
            q qVar = new q();
            qVar.DT(pbSortType.sort_type.intValue());
            qVar.MD(pbSortType.sort_name);
            arrayList.add(qVar);
        }
        this.jQz.setVisibility(0);
        this.jQz.setData(arrayList, i);
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.jHF = aVar;
    }

    public void U(View.OnClickListener onClickListener) {
        this.dUl = onClickListener;
    }
}
