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
    private boolean nnH;
    private SignAllForumActivity nnS;
    private c nnu;
    private ArrayList<d> iFV = new ArrayList<>();
    private HashMap<String, SignSingleModel> nnT = new HashMap<>();
    private boolean iVF = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.nnS = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.nnu = cVar;
            this.iFV = cVar.dKw();
            if (this.iFV.size() == 0) {
                this.iVF = false;
            } else {
                this.iVF = true;
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
        if (this.iVF) {
            return this.iFV.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iFV.size() > i) {
            return this.iFV.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View Jm(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.nnS.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.nnZ = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.nnZ.setIsRound(false);
            bVar.nnZ.setGifIconSupport(false);
            bVar.nob = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.ghW = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.noc = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.nod = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.noe = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.nof = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.nog = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.noh = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.noi = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.noj = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.noa = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.nok = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.nnS.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.nnX = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.nnY = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void b(View view, View view2, int i) {
        String str;
        this.nnS.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.nnS.getLayoutMode().onModeChanged(view);
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
            bVar.nob.setText(str);
            ap.setImageResource(bVar.ghW, BitmapHelper.getSmallGradeResourceIdNew(dVar.bKx()));
            bVar.noc.setText(dVar.dKJ() + "/" + dVar.dKK());
            bVar.nok.clearAnimation();
            if (dVar.bSg()) {
                bVar.noa.setVisibility(0);
                bVar.noj.setVisibility(8);
                bVar.noe.setVisibility(0);
                bVar.nof.setVisibility(8);
                bVar.noe.setText(String.format(this.nnS.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.dKI())));
                if (dVar.dKO()) {
                    bVar.noc.setText(this.nnS.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.nok.setVisibility(8);
                } else {
                    bVar.noc.setText(dVar.dKJ() + "/" + dVar.dKK());
                    bVar.nok.setVisibility(0);
                }
                int dKN = dVar.dKN();
                if (dKN > 0) {
                    bVar.nok.setVisibility(0);
                    bVar.nok.setText("+" + dKN);
                } else {
                    bVar.nok.setVisibility(8);
                }
            } else if (dVar.dKL()) {
                bVar.noa.setVisibility(0);
                bVar.noj.setVisibility(8);
                bVar.nok.setVisibility(8);
                bVar.noe.setVisibility(8);
                bVar.nof.setVisibility(0);
                if (dVar.dKM()) {
                    bVar.nog.setVisibility(4);
                    bVar.noh.setVisibility(0);
                    bVar.noi.setText(R.string.signallforum_resigning);
                } else {
                    bVar.nog.setVisibility(0);
                    bVar.noh.setVisibility(4);
                    bVar.noi.setText(R.string.signallforum_resign);
                }
                bVar.nof.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.dKM()) {
                            bVar.nog.setVisibility(4);
                            bVar.noh.setVisibility(0);
                            bVar.noi.setText(R.string.signallforum_resigning);
                            dVar.ye(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.nnS);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.nnT.put(str2, signSingleModel);
                            }
                            signSingleModel.gr(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.noe.setVisibility(8);
                bVar.nof.setVisibility(8);
                bVar.nok.setVisibility(8);
                bVar.noa.setVisibility(0);
                bVar.noj.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.nnZ.setTag(avatar);
            bVar.nnZ.setPlaceHolder(1);
            bVar.nnZ.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (!this.iVF) {
            return czj();
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
            this.nnS.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.nnS.getLayoutMode().onModeChanged(Jm.findViewById(R.id.sign_all_forum_tip));
            aVar.nnX.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            k(aVar.nnY, i);
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
        int level = this.nnu == null ? 7 : this.nnu.getLevel();
        if (this.iFV == null || this.iFV.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.iFV.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.bKx() >= level) {
                        if (next.bSg()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.bSg()) {
                        i3++;
                    } else {
                        i2++;
                    }
                    i2 = i2;
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.nnS.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.nnS.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View czj() {
        View inflate = LayoutInflater.from(this.nnS.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.nnS.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, this.nnS.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.d.dS(null, this.nnS.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.nnS.getLayoutMode().setNightMode(skinType == 1);
        this.nnS.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.nnS.getPageContext(), skinType);
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
        public ImageView ghW;
        public BarImageView nnZ;
        public LinearLayout noa;
        public TextView nob;
        public TextView noc;
        public FrameLayout nod;
        public TextView noe;
        public RelativeLayout nof;
        public ImageView nog;
        public ProgressBar noh;
        public TextView noi;
        public TextView noj;
        public TextView nok;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a {
        public TextView nnX;
        public TextView nnY;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void c(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.nnT.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void gq(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.nnS.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.nnT.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.iFV.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.iFV.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.yc(z);
                dVar.yd(!z);
                dVar.ye(false);
                if (z) {
                    dVar.Jk(signData.count_sign_num);
                    dVar.Jl(signData.sign_bonus_point);
                    dVar.Jj(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> dKz = this.nnu.dKz();
                    if (dKz.contains(dVar)) {
                        dKz.remove(dVar);
                        this.nnu.dKy().add(dVar);
                    }
                } else {
                    dVar.setErrorMsg(str2);
                }
                if (!this.nnH) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void dKU() {
        this.nnH = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.nnT.entrySet()) {
                    entry.getValue().dLn();
                }
                this.nnT.clear();
            }
        }
    }
}
