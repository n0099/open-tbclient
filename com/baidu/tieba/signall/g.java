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
/* loaded from: classes18.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private c lVM;
    private boolean lVZ;
    private SignAllForumActivity lWk;
    private ArrayList<d> hss = new ArrayList<>();
    private HashMap<String, SignSingleModel> lWl = new HashMap<>();
    private boolean hIk = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.lWk = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.lVM = cVar;
            this.hss = cVar.dtI();
            if (this.hss.size() == 0) {
                this.hIk = false;
            } else {
                this.hIk = true;
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
        if (this.hIk) {
            return this.hss.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.hss.size() > i) {
            return this.hss.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View Hx(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.lWk.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.lWr = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.lWr.setIsRound(false);
            bVar.lWr.setGifIconSupport(false);
            bVar.lWt = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.lWu = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.lWv = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.lWw = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.lWx = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.lWy = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.lWz = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.lWA = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.lWB = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.lWC = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.lWs = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.lWD = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.lWk.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.lWp = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.lWq = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.lWk.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.lWk.getLayoutMode().onModeChanged(view);
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
            bVar.lWt.setText(str);
            ap.setImageResource(bVar.lWu, BitmapHelper.getSmallGradeResourceIdNew(dVar.dtV()));
            bVar.lWv.setText(dVar.dtW() + "/" + dVar.dtX());
            bVar.lWD.clearAnimation();
            if (dVar.bGG()) {
                bVar.lWs.setVisibility(0);
                bVar.lWC.setVisibility(8);
                bVar.lWx.setVisibility(0);
                bVar.lWy.setVisibility(8);
                bVar.lWx.setText(String.format(this.lWk.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.dtU())));
                if (dVar.dub()) {
                    bVar.lWv.setText(this.lWk.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.lWD.setVisibility(8);
                } else {
                    bVar.lWv.setText(dVar.dtW() + "/" + dVar.dtX());
                    bVar.lWD.setVisibility(0);
                }
                int dua = dVar.dua();
                if (dua > 0) {
                    bVar.lWD.setVisibility(0);
                    bVar.lWD.setText("+" + dua);
                } else {
                    bVar.lWD.setVisibility(8);
                }
            } else if (dVar.dtY()) {
                bVar.lWs.setVisibility(0);
                bVar.lWC.setVisibility(8);
                bVar.lWD.setVisibility(8);
                bVar.lWx.setVisibility(8);
                bVar.lWy.setVisibility(0);
                if (dVar.dtZ()) {
                    bVar.lWz.setVisibility(4);
                    bVar.lWA.setVisibility(0);
                    bVar.lWB.setText(R.string.signallforum_resigning);
                } else {
                    bVar.lWz.setVisibility(0);
                    bVar.lWA.setVisibility(4);
                    bVar.lWB.setText(R.string.signallforum_resign);
                }
                bVar.lWy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.dtZ()) {
                            bVar.lWz.setVisibility(4);
                            bVar.lWA.setVisibility(0);
                            bVar.lWB.setText(R.string.signallforum_resigning);
                            dVar.vO(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.lWk);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.lWl.put(str2, signSingleModel);
                            }
                            signSingleModel.fL(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.lWx.setVisibility(8);
                bVar.lWy.setVisibility(8);
                bVar.lWD.setVisibility(8);
                bVar.lWs.setVisibility(0);
                bVar.lWC.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.lWr.setTag(avatar);
            bVar.lWr.setPlaceHolder(1);
            bVar.lWr.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.hIk) {
            return ciJ();
        }
        int itemViewType = getItemViewType(i);
        View Hx = view == null ? Hx(itemViewType) : view;
        if (itemViewType == 1) {
            if (Hx.getTag() != null && (Hx.getTag() instanceof a)) {
                view2 = Hx;
                aVar = (a) Hx.getTag();
            } else {
                View Hx2 = Hx(itemViewType);
                view2 = Hx2;
                aVar = (a) Hx2.getTag();
            }
            this.lWk.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.lWk.getLayoutMode().onModeChanged(view2.findViewById(R.id.sign_all_forum_tip));
            aVar.lWp.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            j(aVar.lWq, i);
            return view2;
        }
        if (Hx.getTag() == null || !(Hx.getTag() instanceof b)) {
            Hx = Hx(itemViewType);
        }
        a(Hx, viewGroup, i);
        return Hx;
    }

    private void j(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.lVM == null ? 7 : this.lVM.getLevel();
        if (this.hss == null || this.hss.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.hss.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.dtV() >= level) {
                        if (next.bGG()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.bGG()) {
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
            format = String.format(this.lWk.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.lWk.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View ciJ() {
        View inflate = LayoutInflater.from(this.lWk.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.lWk.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, this.lWk.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.d.dE(null, this.lWk.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.lWk.getLayoutMode().setNightMode(skinType == 1);
        this.lWk.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.lWk.getPageContext(), skinType);
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
    /* loaded from: classes18.dex */
    public class b {
        public ProgressBar lWA;
        public TextView lWB;
        public TextView lWC;
        public TextView lWD;
        public BarImageView lWr;
        public LinearLayout lWs;
        public TextView lWt;
        public ImageView lWu;
        public TextView lWv;
        public FrameLayout lWw;
        public TextView lWx;
        public RelativeLayout lWy;
        public ImageView lWz;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class a {
        public TextView lWp;
        public TextView lWq;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void c(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.lWl.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void fK(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.lWk.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.lWl.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.hss.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.hss.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.vM(z);
                dVar.vN(!z);
                dVar.vO(false);
                if (z) {
                    dVar.Hu(signData.count_sign_num);
                    dVar.Hw(signData.sign_bonus_point);
                    dVar.Ht(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> dtL = this.lVM.dtL();
                    if (dtL.contains(dVar)) {
                        dtL.remove(dVar);
                        this.lVM.dtK().add(dVar);
                    }
                } else {
                    dVar.setErrorMsg(str2);
                }
                if (!this.lVZ) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void duh() {
        this.lVZ = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.lWl.entrySet()) {
                    entry.getValue().duA();
                }
                this.lWl.clear();
            }
        }
    }
}
