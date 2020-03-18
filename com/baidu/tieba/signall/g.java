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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.SignSingleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes11.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private boolean isDestory;
    private c kac;
    private SignAllForumActivity kax;
    private ArrayList<d> fTp = new ArrayList<>();
    private HashMap<String, SignSingleModel> kay = new HashMap<>();
    private boolean geN = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.kax = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.kac = cVar;
            this.fTp = cVar.cIS();
            if (this.fTp.size() == 0) {
                this.geN = false;
            } else {
                this.geN = true;
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
        if (this.geN) {
            return this.fTp.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fTp.size() > i) {
            return this.fTp.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View Cq(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.kax.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.kaE = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.kaE.setIsRound(false);
            bVar.kaE.setGifIconSupport(false);
            bVar.kaG = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.kaH = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.kaI = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.kaJ = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.kaK = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.kaL = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.kaM = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.kaN = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.kaO = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.kaP = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.kaF = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.kaQ = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.kax.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.kaC = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.kaD = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.kax.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.kax.getLayoutMode().onModeChanged(view);
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
            bVar.kaG.setText(str);
            am.setImageResource(bVar.kaH, BitmapHelper.getSmallGradeResourceIdNew(dVar.cJf()));
            bVar.kaI.setText(dVar.cJg() + "/" + dVar.cJh());
            bVar.kaQ.clearAnimation();
            if (dVar.bdm()) {
                bVar.kaF.setVisibility(0);
                bVar.kaP.setVisibility(8);
                bVar.kaK.setVisibility(0);
                bVar.kaL.setVisibility(8);
                bVar.kaK.setText(String.format(this.kax.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.cJe())));
                if (dVar.cJl()) {
                    bVar.kaI.setText(this.kax.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.kaQ.setVisibility(8);
                } else {
                    bVar.kaI.setText(dVar.cJg() + "/" + dVar.cJh());
                    bVar.kaQ.setVisibility(0);
                }
                int cJk = dVar.cJk();
                if (cJk > 0) {
                    bVar.kaQ.setVisibility(0);
                    bVar.kaQ.setText("+" + cJk);
                } else {
                    bVar.kaQ.setVisibility(8);
                }
            } else if (dVar.cJi()) {
                bVar.kaF.setVisibility(0);
                bVar.kaP.setVisibility(8);
                bVar.kaQ.setVisibility(8);
                bVar.kaK.setVisibility(8);
                bVar.kaL.setVisibility(0);
                if (dVar.cJj()) {
                    bVar.kaM.setVisibility(4);
                    bVar.kaN.setVisibility(0);
                    bVar.kaO.setText(R.string.signallforum_resigning);
                } else {
                    bVar.kaM.setVisibility(0);
                    bVar.kaN.setVisibility(4);
                    bVar.kaO.setText(R.string.signallforum_resign);
                }
                bVar.kaL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.cJj()) {
                            bVar.kaM.setVisibility(4);
                            bVar.kaN.setVisibility(0);
                            bVar.kaO.setText(R.string.signallforum_resigning);
                            dVar.sH(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.kax);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.kay.put(str2, signSingleModel);
                            }
                            signSingleModel.ev(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.kaK.setVisibility(8);
                bVar.kaL.setVisibility(8);
                bVar.kaQ.setVisibility(8);
                bVar.kaF.setVisibility(0);
                bVar.kaP.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.kaE.setTag(avatar);
            bVar.kaE.setPlaceHolder(1);
            bVar.kaE.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.geN) {
            return bBb();
        }
        int itemViewType = getItemViewType(i);
        View Cq = view == null ? Cq(itemViewType) : view;
        if (itemViewType == 1) {
            if (Cq.getTag() != null && (Cq.getTag() instanceof a)) {
                view2 = Cq;
                aVar = (a) Cq.getTag();
            } else {
                View Cq2 = Cq(itemViewType);
                view2 = Cq2;
                aVar = (a) Cq2.getTag();
            }
            this.kax.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.kax.getLayoutMode().onModeChanged(view2.findViewById(R.id.sign_all_forum_tip));
            aVar.kaC.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            h(aVar.kaD, i);
            return view2;
        }
        if (Cq.getTag() == null || !(Cq.getTag() instanceof b)) {
            Cq = Cq(itemViewType);
        }
        a(Cq, viewGroup, i);
        return Cq;
    }

    private void h(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.kac == null ? 7 : this.kac.getLevel();
        if (this.fTp == null || this.fTp.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.fTp.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.cJf() >= level) {
                        if (next.bdm()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.bdm()) {
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
            format = String.format(this.kax.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.kax.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View bBb() {
        View inflate = LayoutInflater.from(this.kax.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.kax.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, this.kax.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.d.cz(null, this.kax.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kax.getLayoutMode().setNightMode(skinType == 1);
        this.kax.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.kax.getPageContext(), skinType);
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
    /* loaded from: classes11.dex */
    public class b {
        public BarImageView kaE;
        public LinearLayout kaF;
        public TextView kaG;
        public ImageView kaH;
        public TextView kaI;
        public FrameLayout kaJ;
        public TextView kaK;
        public RelativeLayout kaL;
        public ImageView kaM;
        public ProgressBar kaN;
        public TextView kaO;
        public TextView kaP;
        public TextView kaQ;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a {
        public TextView kaC;
        public TextView kaD;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void c(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.kay.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void eu(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.kax.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.kay.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.fTp.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.fTp.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.sF(z);
                dVar.sG(!z);
                dVar.sH(false);
                if (z) {
                    dVar.Cn(signData.count_sign_num);
                    dVar.Cp(signData.sign_bonus_point);
                    dVar.Cm(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> cIV = this.kac.cIV();
                    if (cIV.contains(dVar)) {
                        cIV.remove(dVar);
                        this.kac.cIU().add(dVar);
                    }
                } else {
                    dVar.setErrorMsg(str2);
                }
                if (!this.isDestory) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void cJr() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.kay.entrySet()) {
                    entry.getValue().cJK();
                }
                this.kay.clear();
            }
        }
    }
}
