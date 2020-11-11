package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.c;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.HeadItem;
import tbclient.Item;
import tbclient.PbContent;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes.dex */
public class PostData implements q, ah {
    @Deprecated
    private String authorId;
    private String bimg_url;
    private List<HeadItem> eBS;
    private SkinInfo eFH;
    private String eFK;
    private OriginalThreadInfo eGn;
    private Item eHe;
    private TbRichTextVoiceInfo eXi;
    private SmallTailInfo lJP;
    private String lny;
    public int locate;
    private String mWZ;
    public boolean mXB;
    public AlaLiveInfoCoreData mXE;
    private boolean mXI;
    public aq mXM;
    public List<PbContent> mXP;
    private ArrayList<PostData> mXd;
    private com.baidu.tbadk.data.c mXk;
    private com.baidu.tbadk.data.f mXl;
    private i mXo;
    private bs mXp;
    public boolean mXr;
    private com.baidu.tbadk.widget.richText.j mXs;
    private String mXt;
    private String mXu;
    private TPointPost mXv;
    public int mXy;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId mWQ = BdUniqueId.gen();
    public static final BdUniqueId mWR = BdUniqueId.gen();
    public static final BdUniqueId eFI = BdUniqueId.gen();
    public static final BdUniqueId eDR = BdUniqueId.gen();
    public static final BdUniqueId eDW = BdUniqueId.gen();
    public static final BdUniqueId mWS = BdUniqueId.gen();
    public static final BdUniqueId mWT = BdUniqueId.gen();
    public static final BdUniqueId mWU = BdUniqueId.gen();
    public static final BdUniqueId mWV = BdUniqueId.gen();
    public static final BdUniqueId mWW = BdUniqueId.gen();
    public static boolean mWX = false;
    private int mWY = 0;
    private boolean mXe = false;
    private ArrayList<PostData> mXf = null;
    private TbRichText mXg = null;
    private boolean mXj = false;
    private boolean mXm = false;
    private boolean mXn = false;
    public boolean mXq = false;
    public int eFh = 0;
    private boolean mXw = false;
    public boolean iQk = false;
    public boolean mXx = false;
    public boolean mXz = false;
    public boolean mXA = true;
    public boolean mXC = false;
    public boolean mXD = false;
    private boolean mXF = false;
    private int mXG = 0;
    private boolean mXH = true;
    public boolean mXJ = false;
    public boolean mXK = false;
    public boolean mXL = false;
    public boolean mXN = false;
    public boolean mXO = false;
    private b mXQ = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.mXM != null) {
                aq brj = PostData.this.mXM.brj();
                brj.delete("obj_locate");
                brj.al("obj_locate", 7);
                TiebaStatic.log(brj);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData eEK = new MetaData();
    private ArrayList<l> mXa = new ArrayList<>();
    private ArrayList<l> mXb = new ArrayList<>();
    private int mXc = 0;
    private int eFs = 0;
    private PraiseData eEV = new PraiseData();
    private ax mXh = new ax();
    private c mXi = new c();
    private ArrayList<com.baidu.tbadk.data.c> eFE = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.mXd = null;
        this.mXy = 0;
        this.mXd = new ArrayList<>();
        this.mXy = 0;
    }

    public void xq(boolean z) {
        this.mXI = z;
    }

    public boolean dJR() {
        return this.mXI;
    }

    public ArrayList<PostData> dJS() {
        return this.mXf;
    }

    public void dJT() {
        this.mXf.clear();
        this.mXf = null;
        this.mXe = false;
    }

    public void w(PostData postData) {
        if (postData != null) {
            if (this.mXf == null) {
                this.mXf = new ArrayList<>();
                if (y.getCount(this.mXd) > 2) {
                    this.mXf.addAll(y.subList(this.mXd, 0, 2));
                } else {
                    this.mXf.addAll(this.mXd);
                }
            }
            this.mXf.add(postData);
        }
    }

    public void x(PostData postData) {
        if (postData != null && this.mXd != null) {
            this.mXd.add(postData);
            dJX();
        }
    }

    public void SR(String str) {
        if (this.mXf != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.mXf.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.mXf.remove(next);
                    return;
                }
            }
        }
    }

    public void xr(boolean z) {
        this.mXH = z;
    }

    public boolean dJU() {
        return this.mXH;
    }

    public void xs(boolean z) {
        this.mXe = z;
    }

    public boolean dJV() {
        return this.mXe;
    }

    public ArrayList<PostData> dJW() {
        return this.mXd;
    }

    public void dJX() {
        this.mXc++;
    }

    public void dJY() {
        this.mXc--;
    }

    public void JC(int i) {
        this.mXc = i;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public long getTid() {
        return this.tid;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int dJZ() {
        return this.floor_num;
    }

    public void JD(int i) {
        this.floor_num = i;
    }

    public boolean dKa() {
        return this.mXn;
    }

    public void xt(boolean z) {
        this.mXn = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = at.getFormatTime(j);
    }

    public MetaData bmA() {
        return this.eEK;
    }

    public void a(MetaData metaData) {
        this.eEK = metaData;
    }

    public void a(PraiseData praiseData) {
        this.eEV = praiseData;
    }

    public TbRichText dKb() {
        return this.mXg;
    }

    public void c(TbRichText tbRichText) {
        this.mXg = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo dqh() {
        return this.lJP;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.lJP = smallTailInfo;
    }

    public com.baidu.tbadk.data.f dKc() {
        return this.mXl;
    }

    public SkinInfo bmW() {
        return this.eFH;
    }

    public void xu(boolean z) {
        this.mXF = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.mXg != null && this.mXg.bFI() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.eEK != null && this.eEK.getIs_bawu() == 1) {
                    if (this.mXI) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.eEK.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.eEK.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.eEK.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.eEK.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = bmA().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.mS().loadResourceFromMemery(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.e.c.mS().a(next.getIcon(), 21, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.e.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.isValidNow()) {
                                            cVar2.setDrawable(PostData.this.j(aVar2));
                                            PostData.this.mXg.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.j(aVar);
                        }
                    }, 0, 1);
                    cVar.setEmptyBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.eEK.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.eEK.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.eEK == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.eEK.getName_show() + str + "：");
                str2 = this.eEK.getUserName();
                str3 = this.eEK.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.eEK.getSealPrefix())) {
                Bitmap bitmap = ap.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.eEK.getSealPrefix().length() + 1;
                spannableString.setSpan(iVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.mXQ), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.eEK != null && this.eEK.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b f = f(z, this.eEK != null && this.eEK.getIs_bawu() == 1, str);
                if (f != null) {
                    if (this.eEK != null) {
                        int i3 = 0;
                        if (this.eEK.getName_show() != null) {
                            i3 = this.eEK.getName_show().length();
                        }
                        spannableString.setSpan(f, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(f, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> bFI = this.mXg.bFI();
            if (bFI != null && bFI.size() > 0) {
                TbRichTextData tbRichTextData2 = bFI.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.bFP() != null) {
                    if (this.mXF) {
                        int indexOf = tbRichTextData2.bFP().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.bFP().delete(0, indexOf + 1);
                        }
                        this.mXF = false;
                    }
                    tbRichTextData2.sz(sb.length());
                    tbRichTextData2.bFP().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= bFI.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (bFI.get(i5) == null || bFI.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo bFQ = bFI.get(i5).bFQ();
                            bFI.remove(i5);
                            tbRichTextVoiceInfo = bFQ;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.sz(sb.length());
                    tbRichTextData.o(spannableString);
                    bFI.add(0, tbRichTextData);
                }
            }
            this.mXJ = true;
        }
    }

    private com.baidu.tbadk.core.view.b f(boolean z, boolean z2, String str) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        com.baidu.tbadk.core.view.b bVar = new com.baidu.tbadk.core.view.b(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds5), R.color.cp_link_tip_a, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26), R.color.cp_bg_line_d, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds12), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds40));
        bVar.jk(true);
        if (" 吧主".equals(str) || " 小吧主".equals(str) || " 楼主".equals(str) || " 品牌官".equals(str)) {
            bVar.pE(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds6));
            bVar.Co(str);
            return bVar;
        }
        return bVar;
    }

    protected Drawable j(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (aVar == null || (rawBitmap = aVar.getRawBitmap()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(rawBitmap);
        bitmapDrawable.setBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
        return bitmapDrawable;
    }

    public int dKd() {
        return this.mXc;
    }

    public void fS(Context context) {
        int type;
        int i;
        int i2;
        if (this.mXa != null) {
            int i3 = -1;
            int size = this.mXb.size();
            if (size > 0) {
                try {
                    i3 = this.mXb.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.mXa.size()) {
                l lVar = this.mXa.get(i4);
                if (l.dt(i5, lVar.getType())) {
                    this.mXb.get(size - 1).b(lVar.fR(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.mXb.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.fR(context));
                        this.mXb.add(lVar2);
                        type = 0;
                    }
                    i = type;
                    i2 = size + 1;
                }
                i4++;
                i5 = i;
                size = i2;
            }
        }
    }

    public void fT(Context context) {
        try {
            if (this.mXg != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.mXg.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.mXb == null || this.mXb.size() == 0) {
                fS(context);
            }
            ArrayList<l> arrayList = this.mXb;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.dJJ() != null) {
                            sb.append((CharSequence) next.dJJ());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String DF = TbFaceManager.bBc().DF(next.getText());
                        if (DF != null) {
                            sb.append("[");
                            sb.append(DF);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !at.isEmpty(next.dJI())) {
                        sb.append("[").append(next.dJI()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                if (clipboardManager2.getText() != null) {
                }
            }
        } catch (NullPointerException e) {
            BdLog.detailException(e);
        }
    }

    public void a(SubPostList subPostList, Context context) {
        a(subPostList, context, false);
    }

    public void a(SubPostList subPostList, Context context, boolean z) {
        MetaData metaData;
        if (subPostList != null) {
            try {
                this.id = String.valueOf(subPostList.id);
                this.title = subPostList.title;
                this.floor_num = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = at.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.mXm = subPostList.is_giftpost.intValue() == 1;
                this.agreeData.postId = this.id;
                this.agreeData.parseProtobuf(subPostList.agree);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eEK = metaData;
                }
                if (this.eEK.getUserId() == null || this.eEK.getUserId().length() <= 0 || this.eEK.getUserId().equals("0")) {
                    this.eEK = metaData2;
                }
                this.mXg = TbRichTextView.a(context, subPostList.content, z);
                if (this.mXg != null) {
                    this.mXg.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        TbRichTextData tbRichTextData;
        int i;
        MetaData metaData;
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.tid = post.tid.longValue();
                this.title = post.title;
                this.floor_num = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = at.getFormatTime(this.time);
                this.mWZ = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eEK = metaData;
                }
                this.iQk = post.need_log.intValue() == 1;
                this.mXx = post.img_num_abtest.intValue() == 1;
                this.mXp = new bs();
                this.mXp.parserProtobuf(post.from_forum);
                if (this.eEK.getUserId() == null || this.eEK.getUserId().length() <= 0 || this.eEK.getUserId().equals("0")) {
                    this.eEK.parserProtobuf(post.author);
                }
                if (this.eEK != null && context != null) {
                    this.mXt = this.eEK.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.mXu = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.eEK.getLevel_id()));
                }
                this.mXj = post.is_ntitle.intValue() == 1;
                this.mXc = post.sub_post_number.intValue();
                this.mXo = new i(post.tpoint_post);
                List<PbContent> list = post.content;
                this.mXP = post.content;
                this.mXN = post.is_wonderful_post.intValue() == 1;
                this.mXK = post.is_top_agree_post.intValue() == 1;
                this.eBS = post.item_star;
                if (post.item != null && post.item.item_id.longValue() != 0) {
                    this.eHe = post.item;
                }
                this.mXg = TbRichTextView.a(context, list, true);
                if (this.mXg != null) {
                    this.mXg.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.mXg.sy(this.floor_num);
                    if (this.eEK != null) {
                        this.mXg.setAuthorId(this.eEK.getUserId());
                    }
                    int count = y.getCount(this.eBS);
                    if (this.floor_num == 1 && count != 0 && this.eBS != null) {
                        ArrayList<TbRichTextData> bFI = this.mXg.bFI();
                        if (count == 1) {
                            TbRichTextData tbRichTextData2 = (TbRichTextData) y.getItem(bFI, 0);
                            if (tbRichTextData2 == null || tbRichTextData2.getType() != 1) {
                                TbRichTextData tbRichTextData3 = new TbRichTextData(1);
                                y.add(bFI, 0, tbRichTextData3);
                                tbRichTextData = tbRichTextData3;
                            } else {
                                tbRichTextData = tbRichTextData2;
                            }
                            HeadItem headItem = (HeadItem) y.getItem(this.eBS, 0);
                            if (headItem != null) {
                                try {
                                    i = Integer.parseInt(headItem.content);
                                } catch (NumberFormatException e) {
                                    i = 0;
                                }
                                tbRichTextData.p(com.baidu.tbadk.widget.richText.e.I(i, false));
                            }
                        } else {
                            for (int size = this.eBS.size() - 1; size >= 0; size--) {
                                HeadItem headItem2 = this.eBS.get(size);
                                if (headItem2 != null) {
                                    a(bFI, headItem2);
                                }
                            }
                        }
                    }
                    if (this.floor_num == 1 && this.eHe != null) {
                        TbRichTextData tbRichTextData4 = new TbRichTextData(1281);
                        tbRichTextData4.a(new TbRichTextEvaluateItemInfo(this.eHe));
                        y.add(this.mXg.bFI(), tbRichTextData4);
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list2 = subPost.sub_post_list;
                    if (list2.size() > 0) {
                        for (int i2 = 0; i2 < list2.size(); i2++) {
                            SubPostList subPostList = list2.get(i2);
                            PostData postData = new PostData();
                            postData.mXm = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.xq(this.mXI);
                            postData.a(subPostList, context);
                            this.mXd.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.mXi.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.mXk = new com.baidu.tbadk.data.c();
                    this.mXk.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.mXl = new com.baidu.tbadk.data.f();
                    this.mXl.a(post.lbs_info);
                }
                this.eFs = post.storecount.intValue();
                this.mXh.a(post.present);
                this.eEV.setUserMap(this.userMap);
                this.eEV.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.lJP = new SmallTailInfo();
                    this.lJP.id = post.signature.signature_id.intValue();
                    this.lJP.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.lJP.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.lJP.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.lJP.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i3 = 0; i3 != post.ext_tails.size(); i3++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i3));
                        this.eFE.add(cVar);
                    }
                }
                this.eFH = post.skin_info;
                this.eFK = post.lego_card;
                this.mXv = post.tpoint_post;
                if (post.agree != null) {
                    this.mXw = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.mXw = false;
                }
                this.mXD = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.eGn = new OriginalThreadInfo();
                    this.eGn.a(post.origin_thread_info);
                } else {
                    this.eGn = null;
                }
                this.mXG = post.is_fold.intValue();
                this.lny = post.fold_tip;
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(List<TbRichTextData> list, HeadItem headItem) {
        int i;
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new SpannableString(headItem.name + ": " + (headItem.type.intValue() == 1 ? headItem.content : " ")));
        if (headItem.type.intValue() == 2) {
            try {
                i = Integer.parseInt(headItem.content);
            } catch (NumberFormatException e) {
                i = 0;
            }
            spannableStringBuilder.append((CharSequence) com.baidu.tbadk.widget.richText.e.I(i, true));
        }
        tbRichTextData.o(spannableStringBuilder);
        y.add(list, 0, tbRichTextData);
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int mColorId;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(this.mColorId));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private String mId;
        private String mName;
        private SoftReference<Context> mXW;
        private b mXX;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.mXW = new SoftReference<>(context);
            this.mXX = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(R.color.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.mXW != null && this.mXW.get() != null) {
                if (this.mXX != null) {
                    this.mXX.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mXW.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String fU(Context context) {
        ArrayList<TbRichTextData> bFI;
        if (this.mXg == null || (bFI = this.mXg.bFI()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = bFI.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.bFP().toString());
            } else if (next.getType() == 17) {
                String str = next.bFT().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(R.string.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(R.string.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(R.string.video_title_str) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public String dKe() {
        ArrayList<TbRichTextData> bFI;
        String str;
        if (this.mXg == null || (bFI = this.mXg.bFI()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = bFI.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.bFP().toString());
                } else if (next.getType() == 17) {
                    if (next.bFT() != null && next.bFT().mGifInfo != null && (str = next.bFT().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo dKf() {
        ArrayList<TbRichTextData> bFI;
        if (this.mXg != null && (bFI = this.mXg.bFI()) != null) {
            Iterator<TbRichTextData> it = bFI.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.bFO().getWidth();
                    preLoadImageInfo.height = next.bFO().getHeight();
                    preLoadImageInfo.imgUrl = next.bFO().bGe();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.bFU().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.bFU().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.bFU().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String dKg() {
        k dJG;
        PreLoadImageInfo dKf = dKf();
        if (dKf != null && !StringUtils.isNull(dKf.imgUrl)) {
            return dKf.imgUrl;
        }
        if (this.mXo != null && (dJG = this.mXo.dJG()) != null && !StringUtils.isNull(dJG.dJH())) {
            return dJG.dJH();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> bFI;
        if (this.mXg == null || (bFI = this.mXg.bFI()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = bFI.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.bFO().getWidth();
                preLoadImageInfo.height = next.bFO().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.bFO().bGj()) {
                    preLoadImageInfo.imgUrl = next.bFO().bGf();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.bFO().bGe();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.bFT() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.bFT().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.bFT().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.bFT();
                preLoadImageInfo2.procType = 20;
                arrayList.add(preLoadImageInfo2);
            }
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.bimg_url;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.procType = 19;
            arrayList.add(preLoadImageInfo3);
        }
        if (this.eEK == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.eEK.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.mWY == 52) {
            return mWU;
        }
        if (this.mWY == 1) {
            return eFI;
        }
        if (this.mWY == 36) {
            return eDR;
        }
        if (this.mWY == 40 || this.mWY == 50) {
            return eDW;
        }
        if (this.mWY == 41) {
            return mWS;
        }
        if (this.mWY == 53) {
            return mWV;
        }
        if (dJZ() == 1) {
            return mWQ;
        }
        return mWR;
    }

    public void setPostType(int i) {
        this.mWY = i;
    }

    public ax dKh() {
        return this.mXh;
    }

    public void a(ax axVar) {
        this.mXh = axVar;
    }

    public i dKi() {
        return this.mXo;
    }

    public com.baidu.tbadk.widget.richText.j bFS() {
        if (this.mXs != null) {
            return this.mXs;
        }
        if (this.mXg != null && y.getCount(this.mXg.bFI()) > 0) {
            Iterator<TbRichTextData> it = this.mXg.bFI().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.mXs = next.bFS();
                    return this.mXs;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo bFQ() {
        if (this.eXi != null) {
            return this.eXi;
        }
        if (this.mXg != null && y.getCount(this.mXg.bFI()) > 0) {
            Iterator<TbRichTextData> it = this.mXg.bFI().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.eXi = next.bFQ();
                    return this.eXi;
                }
            }
        }
        return null;
    }

    public String dKj() {
        return this.mXt;
    }

    public String bnK() {
        return this.eFK;
    }

    public void bnM() {
        if (this.eFh == 0) {
            this.eFh = 1;
        }
    }

    public long bnZ() {
        return this.agreeData.disAgreeNum;
    }

    public int bob() {
        return this.agreeData.agreeType;
    }

    public AgreeData bor() {
        return this.agreeData;
    }

    public OriginalThreadInfo dKk() {
        return this.eGn;
    }

    public void h(OriginalThreadInfo originalThreadInfo) {
        this.eGn = originalThreadInfo;
    }

    public int dKl() {
        return this.mXG;
    }

    public String div() {
        return this.lny;
    }
}
