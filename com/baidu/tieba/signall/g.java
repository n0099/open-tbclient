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
/* loaded from: classes9.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private boolean isDestory;
    private SignAllForumActivity jXH;
    private c jXn;
    private ArrayList<d> fPW = new ArrayList<>();
    private HashMap<String, SignSingleModel> jXI = new HashMap<>();
    private boolean gbO = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.jXH = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.jXn = cVar;
            this.fPW = cVar.cGR();
            if (this.fPW.size() == 0) {
                this.gbO = false;
            } else {
                this.gbO = true;
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
        if (this.gbO) {
            return this.fPW.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fPW.size() > i) {
            return this.fPW.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View Cb(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.jXH.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.jXO = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.jXO.setIsRound(false);
            bVar.jXO.setGifIconSupport(false);
            bVar.jXQ = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.jXR = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.jXS = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.jXT = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.jXU = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.jXV = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.jXW = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.jXX = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.jXY = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.jXZ = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.jXP = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.jYa = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.jXH.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.jXM = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.jXN = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.jXH.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jXH.getLayoutMode().onModeChanged(view);
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
            bVar.jXQ.setText(str);
            am.setImageResource(bVar.jXR, BitmapHelper.getSmallGradeResourceIdNew(dVar.cHe()));
            bVar.jXS.setText(dVar.cHf() + "/" + dVar.cHg());
            bVar.jYa.clearAnimation();
            if (dVar.baP()) {
                bVar.jXP.setVisibility(0);
                bVar.jXZ.setVisibility(8);
                bVar.jXU.setVisibility(0);
                bVar.jXV.setVisibility(8);
                bVar.jXU.setText(String.format(this.jXH.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.cHd())));
                if (dVar.cHk()) {
                    bVar.jXS.setText(this.jXH.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.jYa.setVisibility(8);
                } else {
                    bVar.jXS.setText(dVar.cHf() + "/" + dVar.cHg());
                    bVar.jYa.setVisibility(0);
                }
                int cHj = dVar.cHj();
                if (cHj > 0) {
                    bVar.jYa.setVisibility(0);
                    bVar.jYa.setText("+" + cHj);
                } else {
                    bVar.jYa.setVisibility(8);
                }
            } else if (dVar.cHh()) {
                bVar.jXP.setVisibility(0);
                bVar.jXZ.setVisibility(8);
                bVar.jYa.setVisibility(8);
                bVar.jXU.setVisibility(8);
                bVar.jXV.setVisibility(0);
                if (dVar.cHi()) {
                    bVar.jXW.setVisibility(4);
                    bVar.jXX.setVisibility(0);
                    bVar.jXY.setText(R.string.signallforum_resigning);
                } else {
                    bVar.jXW.setVisibility(0);
                    bVar.jXX.setVisibility(4);
                    bVar.jXY.setText(R.string.signallforum_resign);
                }
                bVar.jXV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.cHi()) {
                            bVar.jXW.setVisibility(4);
                            bVar.jXX.setVisibility(0);
                            bVar.jXY.setText(R.string.signallforum_resigning);
                            dVar.sx(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.jXH);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.jXI.put(str2, signSingleModel);
                            }
                            signSingleModel.eo(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.jXU.setVisibility(8);
                bVar.jXV.setVisibility(8);
                bVar.jYa.setVisibility(8);
                bVar.jXP.setVisibility(0);
                bVar.jXZ.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.jXO.setTag(avatar);
            bVar.jXO.setPlaceHolder(1);
            bVar.jXO.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.gbO) {
            return bzq();
        }
        int itemViewType = getItemViewType(i);
        View Cb = view == null ? Cb(itemViewType) : view;
        if (itemViewType == 1) {
            if (Cb.getTag() != null && (Cb.getTag() instanceof a)) {
                view2 = Cb;
                aVar = (a) Cb.getTag();
            } else {
                View Cb2 = Cb(itemViewType);
                view2 = Cb2;
                aVar = (a) Cb2.getTag();
            }
            this.jXH.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.jXH.getLayoutMode().onModeChanged(view2.findViewById(R.id.sign_all_forum_tip));
            aVar.jXM.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            h(aVar.jXN, i);
            return view2;
        }
        if (Cb.getTag() == null || !(Cb.getTag() instanceof b)) {
            Cb = Cb(itemViewType);
        }
        a(Cb, viewGroup, i);
        return Cb;
    }

    private void h(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.jXn == null ? 7 : this.jXn.getLevel();
        if (this.fPW == null || this.fPW.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.fPW.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.cHe() >= level) {
                        if (next.baP()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.baP()) {
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
            format = String.format(this.jXH.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.jXH.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View bzq() {
        View inflate = LayoutInflater.from(this.jXH.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.jXH.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, this.jXH.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.d.cr(null, this.jXH.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jXH.getLayoutMode().setNightMode(skinType == 1);
        this.jXH.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.jXH.getPageContext(), skinType);
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
    /* loaded from: classes9.dex */
    public class b {
        public BarImageView jXO;
        public LinearLayout jXP;
        public TextView jXQ;
        public ImageView jXR;
        public TextView jXS;
        public FrameLayout jXT;
        public TextView jXU;
        public RelativeLayout jXV;
        public ImageView jXW;
        public ProgressBar jXX;
        public TextView jXY;
        public TextView jXZ;
        public TextView jYa;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a {
        public TextView jXM;
        public TextView jXN;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void c(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.jXI.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void en(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.jXH.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.jXI.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.fPW.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.fPW.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.sv(z);
                dVar.sw(!z);
                dVar.sx(false);
                if (z) {
                    dVar.BY(signData.count_sign_num);
                    dVar.Ca(signData.sign_bonus_point);
                    dVar.BX(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> cGU = this.jXn.cGU();
                    if (cGU.contains(dVar)) {
                        cGU.remove(dVar);
                        this.jXn.cGT().add(dVar);
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

    public void cHq() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.jXI.entrySet()) {
                    entry.getValue().cHJ();
                }
                this.jXI.clear();
            }
        }
    }
}
