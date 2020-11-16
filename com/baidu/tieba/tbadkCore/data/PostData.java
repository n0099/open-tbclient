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
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
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
    private List<HeadItem> eAj;
    private SkinInfo eDZ;
    private OriginalThreadInfo eEF;
    private String eEc;
    private Item eFw;
    private TbRichTextVoiceInfo eWp;
    private SmallTailInfo lKh;
    private String lnO;
    public int locate;
    private String mXR;
    private ArrayList<PostData> mXV;
    private boolean mYA;
    public ar mYE;
    public List<PbContent> mYH;
    private com.baidu.tbadk.data.c mYc;
    private com.baidu.tbadk.data.f mYd;
    private i mYg;
    private bt mYh;
    public boolean mYj;
    private com.baidu.tbadk.widget.richText.i mYk;
    private String mYl;
    private String mYm;
    private TPointPost mYn;
    public int mYq;
    public boolean mYt;
    public AlaLiveInfoCoreData mYw;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId mXI = BdUniqueId.gen();
    public static final BdUniqueId mXJ = BdUniqueId.gen();
    public static final BdUniqueId eEa = BdUniqueId.gen();
    public static final BdUniqueId eCj = BdUniqueId.gen();
    public static final BdUniqueId eCo = BdUniqueId.gen();
    public static final BdUniqueId mXK = BdUniqueId.gen();
    public static final BdUniqueId mXL = BdUniqueId.gen();
    public static final BdUniqueId mXM = BdUniqueId.gen();
    public static final BdUniqueId mXN = BdUniqueId.gen();
    public static final BdUniqueId mXO = BdUniqueId.gen();
    public static boolean mXP = false;
    private int mXQ = 0;
    private boolean mXW = false;
    private ArrayList<PostData> mXX = null;
    private TbRichText mXY = null;
    private boolean mYb = false;
    private boolean mYe = false;
    private boolean mYf = false;
    public boolean mYi = false;
    public int eDz = 0;
    private boolean mYo = false;
    public boolean iQX = false;
    public boolean mYp = false;
    public boolean mYr = false;
    public boolean mYs = true;
    public boolean mYu = false;
    public boolean mYv = false;
    private boolean mYx = false;
    private int mYy = 0;
    private boolean mYz = true;
    public boolean mYB = false;
    public boolean mYC = false;
    public boolean mYD = false;
    public boolean mYF = false;
    public boolean mYG = false;
    private b mYI = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.mYE != null) {
                ar bqx = PostData.this.mYE.bqx();
                bqx.delete("obj_locate");
                bqx.ak("obj_locate", 7);
                TiebaStatic.log(bqx);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData eDc = new MetaData();
    private ArrayList<l> mXS = new ArrayList<>();
    private ArrayList<l> mXT = new ArrayList<>();
    private int mXU = 0;
    private int eDK = 0;
    private PraiseData eDn = new PraiseData();
    private ay mXZ = new ay();
    private c mYa = new c();
    private ArrayList<com.baidu.tbadk.data.c> eDW = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.mXV = null;
        this.mYq = 0;
        this.mXV = new ArrayList<>();
        this.mYq = 0;
    }

    public void xu(boolean z) {
        this.mYA = z;
    }

    public boolean dJI() {
        return this.mYA;
    }

    public ArrayList<PostData> dJJ() {
        return this.mXX;
    }

    public void dJK() {
        this.mXX.clear();
        this.mXX = null;
        this.mXW = false;
    }

    public void x(PostData postData) {
        if (postData != null) {
            if (this.mXX == null) {
                this.mXX = new ArrayList<>();
                if (y.getCount(this.mXV) > 2) {
                    this.mXX.addAll(y.subList(this.mXV, 0, 2));
                } else {
                    this.mXX.addAll(this.mXV);
                }
            }
            this.mXX.add(postData);
        }
    }

    public void y(PostData postData) {
        if (postData != null && this.mXV != null) {
            this.mXV.add(postData);
            dJO();
        }
    }

    public void Ss(String str) {
        if (this.mXX != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.mXX.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.mXX.remove(next);
                    return;
                }
            }
        }
    }

    public void xv(boolean z) {
        this.mYz = z;
    }

    public boolean dJL() {
        return this.mYz;
    }

    public void xw(boolean z) {
        this.mXW = z;
    }

    public boolean dJM() {
        return this.mXW;
    }

    public ArrayList<PostData> dJN() {
        return this.mXV;
    }

    public void dJO() {
        this.mXU++;
    }

    public void dJP() {
        this.mXU--;
    }

    public void Ke(int i) {
        this.mXU = i;
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

    public int dJQ() {
        return this.floor_num;
    }

    public void Kf(int i) {
        this.floor_num = i;
    }

    public boolean dJR() {
        return this.mYf;
    }

    public void xx(boolean z) {
        this.mYf = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = au.getFormatTime(j);
    }

    public MetaData blC() {
        return this.eDc;
    }

    public void a(MetaData metaData) {
        this.eDc = metaData;
    }

    public void a(PraiseData praiseData) {
        this.eDn = praiseData;
    }

    public TbRichText dJS() {
        return this.mXY;
    }

    public void c(TbRichText tbRichText) {
        this.mXY = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo dpH() {
        return this.lKh;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.lKh = smallTailInfo;
    }

    public com.baidu.tbadk.data.f dJT() {
        return this.mYd;
    }

    public SkinInfo blY() {
        return this.eDZ;
    }

    public void xy(boolean z) {
        this.mYx = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.mXY != null && this.mXY.bFb() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.eDc != null && this.eDc.getIs_bawu() == 1) {
                    if (this.mYA) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.eDc.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.eDc.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.eDc.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.eDc.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = blC().getTShowInfoNew();
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
                                            PostData.this.mXY.isChanged = true;
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
            if (!StringUtils.isNull(this.eDc.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.eDc.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.eDc == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.eDc.getName_show() + str + "：");
                str2 = this.eDc.getUserName();
                str3 = this.eDc.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.eDc.getSealPrefix())) {
                Bitmap bitmap = ap.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.eDc.getSealPrefix().length() + 1;
                spannableString.setSpan(iVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.mYI), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.eDc != null && this.eDc.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b f = f(z, this.eDc != null && this.eDc.getIs_bawu() == 1, str);
                if (f != null) {
                    if (this.eDc != null) {
                        int i3 = 0;
                        if (this.eDc.getName_show() != null) {
                            i3 = this.eDc.getName_show().length();
                        }
                        spannableString.setSpan(f, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(f, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> bFb = this.mXY.bFb();
            if (bFb != null && bFb.size() > 0) {
                TbRichTextData tbRichTextData2 = bFb.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.bFi() != null) {
                    if (this.mYx) {
                        int indexOf = tbRichTextData2.bFi().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.bFi().delete(0, indexOf + 1);
                        }
                        this.mYx = false;
                    }
                    tbRichTextData2.sX(sb.length());
                    tbRichTextData2.bFi().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= bFb.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (bFb.get(i5) == null || bFb.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo bFj = bFb.get(i5).bFj();
                            bFb.remove(i5);
                            tbRichTextVoiceInfo = bFj;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.sX(sb.length());
                    tbRichTextData.p(spannableString);
                    bFb.add(0, tbRichTextData);
                }
            }
            this.mYB = true;
        }
    }

    private com.baidu.tbadk.core.view.b f(boolean z, boolean z2, String str) {
        if (z || z2) {
            Context context = TbadkCoreApplication.getInst().getContext();
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.L_X01);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds12);
            int dimens5 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds40);
            if (" 楼主".equals(str)) {
                com.baidu.tbadk.core.view.b bVar = new com.baidu.tbadk.core.view.b(dimens, -1, R.color.CAM_X0302, dimens3, R.color.CAM_X0302, dimens4, dimens5);
                bVar.qb(dimens2);
                bVar.jl(false);
                bVar.BN(str);
                return bVar;
            } else if (" 吧主".equals(str) || " 小吧主".equals(str) || " 品牌官".equals(str)) {
                com.baidu.tbadk.core.view.b bVar2 = new com.baidu.tbadk.core.view.b(dimens, -1, R.color.CAM_X0302, dimens3, R.color.CAM_X0101, dimens4, dimens5);
                bVar2.qb(dimens2);
                bVar2.jl(true);
                bVar2.BN(str);
                return bVar2;
            } else {
                return null;
            }
        }
        return null;
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

    public int dJU() {
        return this.mXU;
    }

    public void fR(Context context) {
        int type;
        int i;
        int i2;
        if (this.mXS != null) {
            int i3 = -1;
            int size = this.mXT.size();
            if (size > 0) {
                try {
                    i3 = this.mXT.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.mXS.size()) {
                l lVar = this.mXS.get(i4);
                if (l.du(i5, lVar.getType())) {
                    this.mXT.get(size - 1).b(lVar.fQ(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.mXT.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.fQ(context));
                        this.mXT.add(lVar2);
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

    public void fS(Context context) {
        try {
            if (this.mXY != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.mXY.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.mXT == null || this.mXT.size() == 0) {
                fR(context);
            }
            ArrayList<l> arrayList = this.mXT;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.dJA() != null) {
                            sb.append((CharSequence) next.dJA());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String De = TbFaceManager.bAs().De(next.getText());
                        if (De != null) {
                            sb.append("[");
                            sb.append(De);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !au.isEmpty(next.dJz())) {
                        sb.append("[").append(next.dJz()).append("]");
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
                this.date = au.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.mYe = subPostList.is_giftpost.intValue() == 1;
                this.agreeData.postId = this.id;
                this.agreeData.parseProtobuf(subPostList.agree);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eDc = metaData;
                }
                if (this.eDc.getUserId() == null || this.eDc.getUserId().length() <= 0 || this.eDc.getUserId().equals("0")) {
                    this.eDc = metaData2;
                }
                this.mXY = TbRichTextView.a(context, subPostList.content, z);
                if (this.mXY != null) {
                    this.mXY.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
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
                this.date = au.getFormatTime(this.time);
                this.mXR = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eDc = metaData;
                }
                this.iQX = post.need_log.intValue() == 1;
                this.mYp = post.img_num_abtest.intValue() == 1;
                this.mYh = new bt();
                this.mYh.parserProtobuf(post.from_forum);
                if (this.eDc.getUserId() == null || this.eDc.getUserId().length() <= 0 || this.eDc.getUserId().equals("0")) {
                    this.eDc.parserProtobuf(post.author);
                }
                if (this.eDc != null && context != null) {
                    this.mYl = this.eDc.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.mYm = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.eDc.getLevel_id()));
                }
                this.mYb = post.is_ntitle.intValue() == 1;
                this.mXU = post.sub_post_number.intValue();
                this.mYg = new i(post.tpoint_post);
                List<PbContent> list = post.content;
                this.mYH = post.content;
                this.mYF = post.is_wonderful_post.intValue() == 1;
                this.mYC = post.is_top_agree_post.intValue() == 1;
                this.eAj = post.item_star;
                if (post.item != null && post.item.item_id.longValue() != 0) {
                    this.eFw = post.item;
                }
                this.mXY = TbRichTextView.a(context, list, true);
                if (this.mXY != null) {
                    this.mXY.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.mXY.sW(this.floor_num);
                    if (this.eDc != null) {
                        this.mXY.setAuthorId(this.eDc.getUserId());
                    }
                    int count = y.getCount(this.eAj);
                    if (this.floor_num == 1 && count != 0 && this.eAj != null) {
                        ArrayList<TbRichTextData> bFb = this.mXY.bFb();
                        if (count == 1) {
                            TbRichTextData tbRichTextData2 = (TbRichTextData) y.getItem(bFb, 0);
                            if (tbRichTextData2 == null || tbRichTextData2.getType() != 1) {
                                TbRichTextData tbRichTextData3 = new TbRichTextData(1);
                                y.add(bFb, 0, tbRichTextData3);
                                tbRichTextData = tbRichTextData3;
                            } else {
                                tbRichTextData = tbRichTextData2;
                            }
                            HeadItem headItem = (HeadItem) y.getItem(this.eAj, 0);
                            if (headItem != null) {
                                try {
                                    i = Integer.parseInt(headItem.content);
                                } catch (NumberFormatException e) {
                                    i = 0;
                                }
                                tbRichTextData.q(com.baidu.tbadk.widget.richText.e.I(i, false));
                            }
                        } else {
                            for (int size = this.eAj.size() - 1; size >= 0; size--) {
                                HeadItem headItem2 = this.eAj.get(size);
                                if (headItem2 != null) {
                                    a(bFb, headItem2);
                                }
                            }
                        }
                    }
                    if (this.floor_num == 1 && this.eFw != null) {
                        TbRichTextData tbRichTextData4 = new TbRichTextData(1281);
                        tbRichTextData4.a(new TbRichTextEvaluateItemInfo(this.eFw));
                        y.add(this.mXY.bFb(), tbRichTextData4);
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list2 = subPost.sub_post_list;
                    if (list2.size() > 0) {
                        for (int i2 = 0; i2 < list2.size(); i2++) {
                            SubPostList subPostList = list2.get(i2);
                            PostData postData = new PostData();
                            postData.mYe = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.xu(this.mYA);
                            postData.a(subPostList, context);
                            this.mXV.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.mYa.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.mYc = new com.baidu.tbadk.data.c();
                    this.mYc.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.mYd = new com.baidu.tbadk.data.f();
                    this.mYd.a(post.lbs_info);
                }
                this.eDK = post.storecount.intValue();
                this.mXZ.a(post.present);
                this.eDn.setUserMap(this.userMap);
                this.eDn.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.lKh = new SmallTailInfo();
                    this.lKh.id = post.signature.signature_id.intValue();
                    this.lKh.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.lKh.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.lKh.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.lKh.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i3 = 0; i3 != post.ext_tails.size(); i3++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i3));
                        this.eDW.add(cVar);
                    }
                }
                this.eDZ = post.skin_info;
                this.eEc = post.lego_card;
                this.mYn = post.tpoint_post;
                if (post.agree != null) {
                    this.mYo = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.mYo = false;
                }
                this.mYv = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.eEF = new OriginalThreadInfo();
                    this.eEF.a(post.origin_thread_info);
                } else {
                    this.eEF = null;
                }
                this.mYy = post.is_fold.intValue();
                this.lnO = post.fold_tip;
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
        tbRichTextData.p(spannableStringBuilder);
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
        private SoftReference<Context> mYO;
        private b mYP;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.mYO = new SoftReference<>(context);
            this.mYP = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(R.color.CAM_X0304));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.mYO != null && this.mYO.get() != null) {
                if (this.mYP != null) {
                    this.mYP.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mYO.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String fT(Context context) {
        ArrayList<TbRichTextData> bFb;
        if (this.mXY == null || (bFb = this.mXY.bFb()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = bFb.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.bFi().toString());
            } else if (next.getType() == 17) {
                String str = next.bFm().mGifInfo.mSharpText;
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

    public String dJV() {
        ArrayList<TbRichTextData> bFb;
        String str;
        if (this.mXY == null || (bFb = this.mXY.bFb()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = bFb.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.bFi().toString());
                } else if (next.getType() == 17) {
                    if (next.bFm() != null && next.bFm().mGifInfo != null && (str = next.bFm().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo dJW() {
        ArrayList<TbRichTextData> bFb;
        if (this.mXY != null && (bFb = this.mXY.bFb()) != null) {
            Iterator<TbRichTextData> it = bFb.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.bFh().getWidth();
                    preLoadImageInfo.height = next.bFh().getHeight();
                    preLoadImageInfo.imgUrl = next.bFh().bFx();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.bFn().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.bFn().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.bFn().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String dJX() {
        k dJx;
        PreLoadImageInfo dJW = dJW();
        if (dJW != null && !StringUtils.isNull(dJW.imgUrl)) {
            return dJW.imgUrl;
        }
        if (this.mYg != null && (dJx = this.mYg.dJx()) != null && !StringUtils.isNull(dJx.dJy())) {
            return dJx.dJy();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> bFb;
        if (this.mXY == null || (bFb = this.mXY.bFb()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = bFb.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.bFh().getWidth();
                preLoadImageInfo.height = next.bFh().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.bFh().bFC()) {
                    preLoadImageInfo.imgUrl = next.bFh().bFy();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.bFh().bFx();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.bFm() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.bFm().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.bFm().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.bFm();
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
        if (this.eDc == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.eDc.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.mXQ == 52) {
            return mXM;
        }
        if (this.mXQ == 1) {
            return eEa;
        }
        if (this.mXQ == 36) {
            return eCj;
        }
        if (this.mXQ == 40 || this.mXQ == 50) {
            return eCo;
        }
        if (this.mXQ == 41) {
            return mXK;
        }
        if (this.mXQ == 53) {
            return mXN;
        }
        if (dJQ() == 1) {
            return mXI;
        }
        return mXJ;
    }

    public void setPostType(int i) {
        this.mXQ = i;
    }

    public ay dJY() {
        return this.mXZ;
    }

    public void a(ay ayVar) {
        this.mXZ = ayVar;
    }

    public i dJZ() {
        return this.mYg;
    }

    public com.baidu.tbadk.widget.richText.i bFl() {
        if (this.mYk != null) {
            return this.mYk;
        }
        if (this.mXY != null && y.getCount(this.mXY.bFb()) > 0) {
            Iterator<TbRichTextData> it = this.mXY.bFb().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.mYk = next.bFl();
                    return this.mYk;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo bFj() {
        if (this.eWp != null) {
            return this.eWp;
        }
        if (this.mXY != null && y.getCount(this.mXY.bFb()) > 0) {
            Iterator<TbRichTextData> it = this.mXY.bFb().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.eWp = next.bFj();
                    return this.eWp;
                }
            }
        }
        return null;
    }

    public String dKa() {
        return this.mYl;
    }

    public String bmO() {
        return this.eEc;
    }

    public void bmQ() {
        if (this.eDz == 0) {
            this.eDz = 1;
        }
    }

    public long bnd() {
        return this.agreeData.disAgreeNum;
    }

    public int bnf() {
        return this.agreeData.agreeType;
    }

    public AgreeData bnv() {
        return this.agreeData;
    }

    public OriginalThreadInfo dKb() {
        return this.eEF;
    }

    public void h(OriginalThreadInfo originalThreadInfo) {
        this.eEF = originalThreadInfo;
    }

    public int dKc() {
        return this.mYy;
    }

    public String dhS() {
        return this.lnO;
    }
}
