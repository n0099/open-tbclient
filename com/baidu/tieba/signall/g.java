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
/* loaded from: classes8.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private c nnU;
    private boolean noh;
    private SignAllForumActivity nos;
    private ArrayList<d> iGj = new ArrayList<>();
    private HashMap<String, SignSingleModel> nou = new HashMap<>();
    private boolean iVT = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.nos = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.nnU = cVar;
            this.iGj = cVar.dKE();
            if (this.iGj.size() == 0) {
                this.iVT = false;
            } else {
                this.iVT = true;
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
        if (this.iVT) {
            return this.iGj.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iGj.size() > i) {
            return this.iGj.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View Jm(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.nos.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.noB = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.noB.setIsRound(false);
            bVar.noB.setGifIconSupport(false);
            bVar.noD = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.gil = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.noE = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.noF = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.noG = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.noH = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.noI = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.noJ = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.noK = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.noL = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.noC = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.noM = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.nos.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.noz = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.noA = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void b(View view, View view2, int i) {
        String str;
        this.nos.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.nos.getLayoutMode().onModeChanged(view);
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
            bVar.noD.setText(str);
            ap.setImageResource(bVar.gil, BitmapHelper.getSmallGradeResourceIdNew(dVar.bKC()));
            bVar.noE.setText(dVar.dKR() + "/" + dVar.dKS());
            bVar.noM.clearAnimation();
            if (dVar.bSn()) {
                bVar.noC.setVisibility(0);
                bVar.noL.setVisibility(8);
                bVar.noG.setVisibility(0);
                bVar.noH.setVisibility(8);
                bVar.noG.setText(String.format(this.nos.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.dKQ())));
                if (dVar.dKW()) {
                    bVar.noE.setText(this.nos.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.noM.setVisibility(8);
                } else {
                    bVar.noE.setText(dVar.dKR() + "/" + dVar.dKS());
                    bVar.noM.setVisibility(0);
                }
                int dKV = dVar.dKV();
                if (dKV > 0) {
                    bVar.noM.setVisibility(0);
                    bVar.noM.setText("+" + dKV);
                } else {
                    bVar.noM.setVisibility(8);
                }
            } else if (dVar.dKT()) {
                bVar.noC.setVisibility(0);
                bVar.noL.setVisibility(8);
                bVar.noM.setVisibility(8);
                bVar.noG.setVisibility(8);
                bVar.noH.setVisibility(0);
                if (dVar.dKU()) {
                    bVar.noI.setVisibility(4);
                    bVar.noJ.setVisibility(0);
                    bVar.noK.setText(R.string.signallforum_resigning);
                } else {
                    bVar.noI.setVisibility(0);
                    bVar.noJ.setVisibility(4);
                    bVar.noK.setText(R.string.signallforum_resign);
                }
                bVar.noH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.dKU()) {
                            bVar.noI.setVisibility(4);
                            bVar.noJ.setVisibility(0);
                            bVar.noK.setText(R.string.signallforum_resigning);
                            dVar.ye(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.nos);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.nou.put(str2, signSingleModel);
                            }
                            signSingleModel.gt(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.noG.setVisibility(8);
                bVar.noH.setVisibility(8);
                bVar.noM.setVisibility(8);
                bVar.noC.setVisibility(0);
                bVar.noL.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.noB.setTag(avatar);
            bVar.noB.setPlaceHolder(1);
            bVar.noB.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (!this.iVT) {
            return czq();
        }
        int itemViewType = getItemViewType(i);
        View Jm = view == null ? Jm(itemViewType) : view;
        if (itemViewType == 1) {
            if (Jm.getTag() != null && (Jm.getTag() instanceof a)) {
                aVar = (a) Jm.getTag();
            } else {
                Jm = Jm(itemViewType);
                aVar = (a) Jm.getTag();
            }
            this.nos.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.nos.getLayoutMode().onModeChanged(Jm.findViewById(R.id.sign_all_forum_tip));
            aVar.noz.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            k(aVar.noA, i);
            return Jm;
        }
        if (Jm.getTag() == null || !(Jm.getTag() instanceof b)) {
            Jm = Jm(itemViewType);
        }
        b(Jm, viewGroup, i);
        return Jm;
    }

    private void k(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.nnU == null ? 7 : this.nnU.getLevel();
        if (this.iGj == null || this.iGj.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.iGj.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.bKC() >= level) {
                        if (next.bSn()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.bSn()) {
                        i3++;
                    } else {
                        i2++;
                    }
                    i2 = i2;
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.nos.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.nos.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View czq() {
        View inflate = LayoutInflater.from(this.nos.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.nos.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, this.nos.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.d.dS(null, this.nos.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.nos.getLayoutMode().setNightMode(skinType == 1);
        this.nos.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.nos.getPageContext(), skinType);
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
    /* loaded from: classes8.dex */
    public class b {
        public ImageView gil;
        public BarImageView noB;
        public LinearLayout noC;
        public TextView noD;
        public TextView noE;
        public FrameLayout noF;
        public TextView noG;
        public RelativeLayout noH;
        public ImageView noI;
        public ProgressBar noJ;
        public TextView noK;
        public TextView noL;
        public TextView noM;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a {
        public TextView noA;
        public TextView noz;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void c(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.nou.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void gs(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.nos.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.nou.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.iGj.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.iGj.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.yc(z);
                dVar.yd(!z);
                dVar.ye(false);
                if (z) {
                    dVar.Jk(signData.count_sign_num);
                    dVar.Jl(signData.sign_bonus_point);
                    dVar.Jj(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> dKH = this.nnU.dKH();
                    if (dKH.contains(dVar)) {
                        dKH.remove(dVar);
                        this.nnU.dKG().add(dVar);
                    }
                } else {
                    dVar.setErrorMsg(str2);
                }
                if (!this.noh) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void dLc() {
        this.noh = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.nou.entrySet()) {
                    entry.getValue().dLv();
                }
                this.nou.clear();
            }
        }
    }
}
