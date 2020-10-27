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
    private c mHM;
    private boolean mHZ;
    private SignAllForumActivity mIl;
    private ArrayList<d> iaV = new ArrayList<>();
    private HashMap<String, SignSingleModel> mIm = new HashMap<>();
    private boolean iqO = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.mIl = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.mHM = cVar;
            this.iaV = cVar.dEz();
            if (this.iaV.size() == 0) {
                this.iqO = false;
            } else {
                this.iqO = true;
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
        if (this.iqO) {
            return this.iaV.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iaV.size() > i) {
            return this.iaV.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View IZ(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.mIl.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.mIu = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.mIu.setIsRound(false);
            bVar.mIu.setGifIconSupport(false);
            bVar.mIw = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.fNp = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.mIx = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.mIy = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.mIz = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.mIA = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.mIB = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.mIC = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.mIE = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.mIF = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.mIv = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.mIG = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.mIl.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.mIr = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.mIt = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.mIl.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mIl.getLayoutMode().onModeChanged(view);
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
            bVar.mIw.setText(str);
            ap.setImageResource(bVar.fNp, BitmapHelper.getSmallGradeResourceIdNew(dVar.dEM()));
            bVar.mIx.setText(dVar.dEN() + "/" + dVar.dEO());
            bVar.mIG.clearAnimation();
            if (dVar.bNl()) {
                bVar.mIv.setVisibility(0);
                bVar.mIF.setVisibility(8);
                bVar.mIz.setVisibility(0);
                bVar.mIA.setVisibility(8);
                bVar.mIz.setText(String.format(this.mIl.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.dEL())));
                if (dVar.dES()) {
                    bVar.mIx.setText(this.mIl.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.mIG.setVisibility(8);
                } else {
                    bVar.mIx.setText(dVar.dEN() + "/" + dVar.dEO());
                    bVar.mIG.setVisibility(0);
                }
                int dER = dVar.dER();
                if (dER > 0) {
                    bVar.mIG.setVisibility(0);
                    bVar.mIG.setText("+" + dER);
                } else {
                    bVar.mIG.setVisibility(8);
                }
            } else if (dVar.dEP()) {
                bVar.mIv.setVisibility(0);
                bVar.mIF.setVisibility(8);
                bVar.mIG.setVisibility(8);
                bVar.mIz.setVisibility(8);
                bVar.mIA.setVisibility(0);
                if (dVar.dEQ()) {
                    bVar.mIB.setVisibility(4);
                    bVar.mIC.setVisibility(0);
                    bVar.mIE.setText(R.string.signallforum_resigning);
                } else {
                    bVar.mIB.setVisibility(0);
                    bVar.mIC.setVisibility(4);
                    bVar.mIE.setText(R.string.signallforum_resign);
                }
                bVar.mIA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.dEQ()) {
                            bVar.mIB.setVisibility(4);
                            bVar.mIC.setVisibility(0);
                            bVar.mIE.setText(R.string.signallforum_resigning);
                            dVar.wW(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.mIl);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.mIm.put(str2, signSingleModel);
                            }
                            signSingleModel.gk(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.mIz.setVisibility(8);
                bVar.mIA.setVisibility(8);
                bVar.mIG.setVisibility(8);
                bVar.mIv.setVisibility(0);
                bVar.mIF.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.mIu.setTag(avatar);
            bVar.mIu.setPlaceHolder(1);
            bVar.mIu.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.iqO) {
            return csC();
        }
        int itemViewType = getItemViewType(i);
        View IZ = view == null ? IZ(itemViewType) : view;
        if (itemViewType == 1) {
            if (IZ.getTag() != null && (IZ.getTag() instanceof a)) {
                view2 = IZ;
                aVar = (a) IZ.getTag();
            } else {
                View IZ2 = IZ(itemViewType);
                view2 = IZ2;
                aVar = (a) IZ2.getTag();
            }
            this.mIl.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.mIl.getLayoutMode().onModeChanged(view2.findViewById(R.id.sign_all_forum_tip));
            aVar.mIr.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            j(aVar.mIt, i);
            return view2;
        }
        if (IZ.getTag() == null || !(IZ.getTag() instanceof b)) {
            IZ = IZ(itemViewType);
        }
        a(IZ, viewGroup, i);
        return IZ;
    }

    private void j(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.mHM == null ? 7 : this.mHM.getLevel();
        if (this.iaV == null || this.iaV.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.iaV.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.dEM() >= level) {
                        if (next.bNl()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.bNl()) {
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
            format = String.format(this.mIl.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.mIl.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View csC() {
        View inflate = LayoutInflater.from(this.mIl.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.mIl.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, this.mIl.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.d.dS(null, this.mIl.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.mIl.getLayoutMode().setNightMode(skinType == 1);
        this.mIl.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.mIl.getPageContext(), skinType);
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
        public ImageView fNp;
        public RelativeLayout mIA;
        public ImageView mIB;
        public ProgressBar mIC;
        public TextView mIE;
        public TextView mIF;
        public TextView mIG;
        public BarImageView mIu;
        public LinearLayout mIv;
        public TextView mIw;
        public TextView mIx;
        public FrameLayout mIy;
        public TextView mIz;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes24.dex */
    public class a {
        public TextView mIr;
        public TextView mIt;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void c(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.mIm.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void gj(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.mIl.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.mIm.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.iaV.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.iaV.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.wU(z);
                dVar.wV(!z);
                dVar.wW(false);
                if (z) {
                    dVar.IW(signData.count_sign_num);
                    dVar.IY(signData.sign_bonus_point);
                    dVar.IV(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> dEC = this.mHM.dEC();
                    if (dEC.contains(dVar)) {
                        dEC.remove(dVar);
                        this.mHM.dEB().add(dVar);
                    }
                } else {
                    dVar.setErrorMsg(str2);
                }
                if (!this.mHZ) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void dEY() {
        this.mHZ = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.mIm.entrySet()) {
                    entry.getValue().dFr();
                }
                this.mIm.clear();
            }
        }
    }
}
