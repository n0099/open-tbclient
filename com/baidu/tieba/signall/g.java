package com.baidu.tieba.signall;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.SignSingleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes24.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private SignAllForumActivity mvE;
    private c mvg;
    private boolean mvt;
    private ArrayList<d> hOy = new ArrayList<>();
    private HashMap<String, SignSingleModel> mvF = new HashMap<>();
    private boolean ieq = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.mvE = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.mvg = cVar;
            this.hOy = cVar.dBr();
            if (this.hOy.size() == 0) {
                this.ieq = false;
            } else {
                this.ieq = true;
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i) instanceof com.baidu.tieba.signall.b ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ieq) {
            return this.hOy.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.hOy.size() > i) {
            return this.hOy.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View IG(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.mvE.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.mvL = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.mvL.setIsRound(false);
            bVar.mvL.setGifIconSupport(false);
            bVar.mvN = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.fEU = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.mvO = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.mvP = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.mvQ = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.mvR = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.mvS = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.mvT = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.mvU = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.mvV = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.mvM = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.mvW = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.mvE.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.mvJ = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.mvK = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.mvE.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mvE.getLayoutMode().onModeChanged(view);
        final b bVar = (b) view.getTag();
        final d dVar = (d) getItem(i);
        if (dVar != null) {
            String forumName = dVar.getForumName();
            if (forumName != null && forumName.length() > 8) {
                char[] charArray = forumName.toCharArray();
                int i2 = 0;
                for (int i3 = 0; i3 < charArray.length; i3++) {
                    if (StringUtils.isChinese(charArray[i3])) {
                        i2 += 2;
                    } else {
                        i2++;
                    }
                    if (i2 > 16) {
                        str = forumName.substring(0, i3) + StringHelper.STRING_MORE;
                        break;
                    }
                }
            }
            str = forumName;
            bVar.mvN.setText(str);
            ap.setImageResource(bVar.fEU, BitmapHelper.getSmallGradeResourceIdNew(dVar.dBE()));
            bVar.mvO.setText(dVar.dBF() + "/" + dVar.dBG());
            bVar.mvW.clearAnimation();
            if (dVar.bKJ()) {
                bVar.mvM.setVisibility(0);
                bVar.mvV.setVisibility(8);
                bVar.mvQ.setVisibility(0);
                bVar.mvR.setVisibility(8);
                bVar.mvQ.setText(String.format(this.mvE.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.dBD())));
                if (dVar.dBK()) {
                    bVar.mvO.setText(this.mvE.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.mvW.setVisibility(8);
                } else {
                    bVar.mvO.setText(dVar.dBF() + "/" + dVar.dBG());
                    bVar.mvW.setVisibility(0);
                }
                int dBJ = dVar.dBJ();
                if (dBJ > 0) {
                    bVar.mvW.setVisibility(0);
                    bVar.mvW.setText("+" + dBJ);
                } else {
                    bVar.mvW.setVisibility(8);
                }
            } else if (dVar.dBH()) {
                bVar.mvM.setVisibility(0);
                bVar.mvV.setVisibility(8);
                bVar.mvW.setVisibility(8);
                bVar.mvQ.setVisibility(8);
                bVar.mvR.setVisibility(0);
                if (dVar.dBI()) {
                    bVar.mvS.setVisibility(4);
                    bVar.mvT.setVisibility(0);
                    bVar.mvU.setText(R.string.signallforum_resigning);
                } else {
                    bVar.mvS.setVisibility(0);
                    bVar.mvT.setVisibility(4);
                    bVar.mvU.setText(R.string.signallforum_resign);
                }
                bVar.mvR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.dBI()) {
                            bVar.mvS.setVisibility(4);
                            bVar.mvT.setVisibility(0);
                            bVar.mvU.setText(R.string.signallforum_resigning);
                            dVar.wF(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.mvE);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.mvF.put(str2, signSingleModel);
                            }
                            signSingleModel.gf(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.mvQ.setVisibility(8);
                bVar.mvR.setVisibility(8);
                bVar.mvW.setVisibility(8);
                bVar.mvM.setVisibility(0);
                bVar.mvV.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.mvL.setTag(avatar);
            bVar.mvL.setPlaceHolder(1);
            bVar.mvL.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.ieq) {
            return cpv();
        }
        int itemViewType = getItemViewType(i);
        View IG = view == null ? IG(itemViewType) : view;
        if (itemViewType == 1) {
            if (IG.getTag() != null && (IG.getTag() instanceof a)) {
                view2 = IG;
                aVar = (a) IG.getTag();
            } else {
                View IG2 = IG(itemViewType);
                view2 = IG2;
                aVar = (a) IG2.getTag();
            }
            this.mvE.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.mvE.getLayoutMode().onModeChanged(view2.findViewById(R.id.sign_all_forum_tip));
            aVar.mvJ.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            j(aVar.mvK, i);
            return view2;
        }
        if (IG.getTag() == null || !(IG.getTag() instanceof b)) {
            IG = IG(itemViewType);
        }
        a(IG, viewGroup, i);
        return IG;
    }

    private void j(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.mvg == null ? 7 : this.mvg.getLevel();
        if (this.hOy == null || this.hOy.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.hOy.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.dBE() >= level) {
                        if (next.bKJ()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.bKJ()) {
                        i3++;
                    } else {
                        i2++;
                    }
                    i5 = i5;
                    i4 = i4;
                    i3 = i3;
                    i2 = i2;
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.mvE.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.mvE.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View cpv() {
        View inflate = LayoutInflater.from(this.mvE.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.mvE.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, this.mvE.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.d.dL(null, this.mvE.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.mvE.getLayoutMode().setNightMode(skinType == 1);
        this.mvE.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.mvE.getPageContext(), skinType);
        a2.setVisibility(0);
        a2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return inflate;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes24.dex */
    public class b {
        public ImageView fEU;
        public BarImageView mvL;
        public LinearLayout mvM;
        public TextView mvN;
        public TextView mvO;
        public FrameLayout mvP;
        public TextView mvQ;
        public RelativeLayout mvR;
        public ImageView mvS;
        public ProgressBar mvT;
        public TextView mvU;
        public TextView mvV;
        public TextView mvW;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes24.dex */
    public class a {
        public TextView mvJ;
        public TextView mvK;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void c(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.mvF.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void ge(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.mvE.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.mvF.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.hOy.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.hOy.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.wD(z);
                dVar.wE(!z);
                dVar.wF(false);
                if (z) {
                    dVar.ID(signData.count_sign_num);
                    dVar.IF(signData.sign_bonus_point);
                    dVar.IC(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> dBu = this.mvg.dBu();
                    if (dBu.contains(dVar)) {
                        dBu.remove(dVar);
                        this.mvg.dBt().add(dVar);
                    }
                } else {
                    dVar.setErrorMsg(str2);
                }
                if (!this.mvt) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void dBQ() {
        this.mvt = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.mvF.entrySet()) {
                    entry.getValue().dCj();
                }
                this.mvF.clear();
            }
        }
    }
}
