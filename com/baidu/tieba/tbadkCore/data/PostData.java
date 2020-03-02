package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
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
import com.baidu.adp.widget.c;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes.dex */
public class PostData implements com.baidu.adp.widget.ListView.m, ae {
    @Deprecated
    private String authorId;
    private String bimg_url;
    private OriginalThreadInfo cTQ;
    private SkinInfo cTk;
    private String cTn;
    private TbRichTextVoiceInfo diq;
    private String iCi;
    private SmallTailInfo iWn;
    private String kgD;
    private ArrayList<PostData> kgH;
    private com.baidu.tbadk.data.c kgO;
    private com.baidu.tbadk.data.f kgP;
    private i kgS;
    private bf kgT;
    public boolean kgV;
    private com.baidu.tbadk.widget.richText.i kgW;
    private String kgX;
    private String kgY;
    private TPointPost kgZ;
    public int khc;
    public boolean khf;
    public AlaLiveInfoCoreData khi;
    private boolean khm;
    private boolean khp;
    public an khr;
    public int locate;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId kgs = BdUniqueId.gen();
    public static final BdUniqueId kgt = BdUniqueId.gen();
    public static final BdUniqueId cTl = BdUniqueId.gen();
    public static final BdUniqueId kgu = BdUniqueId.gen();
    public static final BdUniqueId cRz = BdUniqueId.gen();
    public static final BdUniqueId kgv = BdUniqueId.gen();
    public static final BdUniqueId kgw = BdUniqueId.gen();
    public static final BdUniqueId kgx = BdUniqueId.gen();
    public static final BdUniqueId kgy = BdUniqueId.gen();
    public static final BdUniqueId kgz = BdUniqueId.gen();
    public static boolean kgA = false;
    private int kgB = 0;
    private boolean kgI = false;
    private ArrayList<PostData> kgJ = null;
    private TbRichText kgK = null;
    private boolean kgN = false;
    private boolean kgQ = false;
    private boolean kgR = false;
    public boolean kgU = false;
    public int cSK = 0;
    private boolean kha = false;
    public boolean gvF = false;
    public boolean khb = false;
    public boolean khd = false;
    public boolean khe = true;
    public boolean khg = false;
    public boolean khh = false;
    private boolean khj = false;
    private int khk = 0;
    private boolean khl = true;
    public boolean khn = false;
    public boolean kho = false;
    public boolean khq = false;
    private b khs = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.khr != null) {
                an aGy = PostData.this.khr.aGy();
                aGy.delete("obj_locate");
                aGy.X("obj_locate", 7);
                TiebaStatic.log(aGy);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int kgC = 0;
    private long time = 0;
    private String date = null;
    private MetaData cSn = new MetaData();
    private ArrayList<l> kgE = new ArrayList<>();
    private ArrayList<l> kgF = new ArrayList<>();
    private int kgG = 0;
    private int cSV = 0;
    private PraiseData cSy = new PraiseData();
    private ar kgL = new ar();
    private c kgM = new c();
    private ArrayList<com.baidu.tbadk.data.c> cTh = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.kgH = null;
        this.khc = 0;
        this.kgH = new ArrayList<>();
        this.khc = 0;
    }

    public void sK(boolean z) {
        this.khm = z;
    }

    public boolean cKS() {
        return this.khm;
    }

    public ArrayList<PostData> cKT() {
        return this.kgJ;
    }

    public void cKU() {
        this.kgJ.clear();
        this.kgJ = null;
        this.kgI = false;
    }

    public void t(PostData postData) {
        if (postData != null) {
            if (this.kgJ == null) {
                this.kgJ = new ArrayList<>();
                if (v.getCount(this.kgH) > 2) {
                    this.kgJ.addAll(v.subList(this.kgH, 0, 2));
                } else {
                    this.kgJ.addAll(this.kgH);
                }
            }
            this.kgJ.add(postData);
        }
    }

    public void u(PostData postData) {
        if (postData != null && this.kgH != null) {
            this.kgH.add(postData);
            cKY();
        }
    }

    public void Jb(String str) {
        if (this.kgJ != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.kgJ.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.kgJ.remove(next);
                    return;
                }
            }
        }
    }

    public void sL(boolean z) {
        this.khl = z;
    }

    public boolean cKV() {
        return this.khl;
    }

    public void sM(boolean z) {
        this.kgI = z;
    }

    public boolean cKW() {
        return this.kgI;
    }

    public ArrayList<PostData> cKX() {
        return this.kgH;
    }

    public void cKY() {
        this.kgG++;
    }

    public void cKZ() {
        this.kgG--;
    }

    public void Cv(int i) {
        this.kgG = i;
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

    public int cLa() {
        return this.kgC;
    }

    public void Cw(int i) {
        this.kgC = i;
    }

    public boolean cLb() {
        return this.kgR;
    }

    public void sN(boolean z) {
        this.kgR = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = aq.getFormatTime(j);
    }

    public MetaData aCo() {
        return this.cSn;
    }

    public void a(MetaData metaData) {
        this.cSn = metaData;
    }

    public void a(PraiseData praiseData) {
        this.cSy = praiseData;
    }

    public TbRichText cLc() {
        return this.kgK;
    }

    public void c(TbRichText tbRichText) {
        this.kgK = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo crZ() {
        return this.iWn;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.iWn = smallTailInfo;
    }

    public com.baidu.tbadk.data.f cLd() {
        return this.kgP;
    }

    public SkinInfo aCJ() {
        return this.cTk;
    }

    public void sO(boolean z) {
        this.khj = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.kgK != null && this.kgK.aTS() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.cSn != null && this.cSn.getIs_bawu() == 1) {
                    if (this.khm) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.cSn.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.cSn.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.cSn.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.cSn.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = aCo().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.gr().loadResourceFromMemery(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.e.c.gr().a(next.getIcon(), 21, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.e.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.isValidNow()) {
                                            cVar2.setDrawable(PostData.this.j(aVar2));
                                            PostData.this.kgK.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.j(aVar);
                        }
                    }, 0, 1);
                    cVar.setEmptyBounds(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds32));
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.cSn.getSealPrefix())) {
                sb.append(HanziToPinyin.Token.SEPARATOR);
                sb.append(this.cSn.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(HanziToPinyin.Token.SEPARATOR);
            }
            String sb2 = sb.toString();
            if (this.cSn == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.cSn.getName_show() + str + "：");
                str2 = this.cSn.getUserName();
                str3 = this.cSn.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.cSn.getSealPrefix())) {
                Bitmap bitmap = am.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable);
                jVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.cSn.getSealPrefix().length() + 1;
                spannableString.setSpan(jVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.khs), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.cSn != null && this.cSn.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b e = e(z, this.cSn != null && this.cSn.getIs_bawu() == 1, str);
                if (e != null) {
                    if (this.cSn != null) {
                        int i3 = 0;
                        if (this.cSn.getName_show() != null) {
                            i3 = this.cSn.getName_show().length();
                        }
                        spannableString.setSpan(e, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(e, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> aTS = this.kgK.aTS();
            if (aTS != null && aTS.size() > 0) {
                TbRichTextData tbRichTextData2 = aTS.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.aTZ() != null) {
                    if (this.khj) {
                        int indexOf = tbRichTextData2.aTZ().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.aTZ().delete(0, indexOf + 1);
                        }
                        this.khj = false;
                    }
                    tbRichTextData2.nt(sb.length());
                    tbRichTextData2.aTZ().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= aTS.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (aTS.get(i5) == null || aTS.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo aUa = aTS.get(i5).aUa();
                            aTS.remove(i5);
                            tbRichTextVoiceInfo = aUa;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.nt(sb.length());
                    tbRichTextData.j(spannableString);
                    aTS.add(0, tbRichTextData);
                }
            }
            this.khn = true;
        }
    }

    private com.baidu.tbadk.core.view.b e(boolean z, boolean z2, String str) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        com.baidu.tbadk.core.view.b bVar = new com.baidu.tbadk.core.view.b(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds5), R.color.cp_link_tip_a, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26), R.color.cp_bg_line_d, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds12), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds40));
        bVar.fO(true);
        if (" 吧主".equals(str) || " 小吧主".equals(str) || " 楼主".equals(str) || " 品牌官".equals(str)) {
            bVar.kV(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds6));
            bVar.tR(str);
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
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.ds36));
        return bitmapDrawable;
    }

    public int cLe() {
        return this.kgG;
    }

    public void fu(Context context) {
        int type;
        int i;
        int i2;
        if (this.kgE != null) {
            int i3 = -1;
            int size = this.kgF.size();
            if (size > 0) {
                try {
                    i3 = this.kgF.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.kgE.size()) {
                l lVar = this.kgE.get(i4);
                if (l.cK(i5, lVar.getType())) {
                    this.kgF.get(size - 1).b(lVar.ft(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.kgF.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.ft(context));
                        this.kgF.add(lVar2);
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

    public void fv(Context context) {
        try {
            if (this.kgK != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.kgK.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.kgF == null || this.kgF.size() == 0) {
                fu(context);
            }
            ArrayList<l> arrayList = this.kgF;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.cKL() != null) {
                            sb.append((CharSequence) next.cKL());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String vd = TbFaceManager.aPP().vd(next.getText());
                        if (vd != null) {
                            sb.append("[");
                            sb.append(vd);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !aq.isEmpty(next.cKK())) {
                        sb.append("[").append(next.cKK()).append("]");
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
                this.kgC = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = aq.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.kgQ = subPostList.is_giftpost.intValue() == 1;
                this.agreeData.postId = this.id;
                this.agreeData.parseProtobuf(subPostList.agree);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.cSn = metaData;
                }
                if (this.cSn.getUserId() == null || this.cSn.getUserId().length() <= 0 || this.cSn.getUserId().equals("0")) {
                    this.cSn = metaData2;
                }
                this.kgK = TbRichTextView.a(context, subPostList.content, z);
                if (this.kgK != null) {
                    this.kgK.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        MetaData metaData;
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.tid = post.tid.longValue();
                this.title = post.title;
                this.kgC = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = aq.getFormatTime(this.time);
                this.kgD = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.cSn = metaData;
                }
                this.gvF = post.need_log.intValue() == 1;
                this.khb = post.img_num_abtest.intValue() == 1;
                this.kgT = new bf();
                this.kgT.parserProtobuf(post.from_forum);
                if (this.cSn.getUserId() == null || this.cSn.getUserId().length() <= 0 || this.cSn.getUserId().equals("0")) {
                    this.cSn.parserProtobuf(post.author);
                }
                if (this.cSn != null && context != null) {
                    this.kgX = this.cSn.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.kgY = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.cSn.getLevel_id()));
                }
                this.kgN = post.is_ntitle.intValue() == 1;
                this.kgG = post.sub_post_number.intValue();
                this.kgS = new i(post.tpoint_post);
                this.kgK = TbRichTextView.a(context, post.content, true);
                if (this.kgK != null) {
                    this.kgK.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.kgK.ns(this.kgC);
                    if (this.cSn != null) {
                        this.kgK.setAuthorId(this.cSn.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.kgQ = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.sK(this.khm);
                            postData.a(subPostList, context);
                            this.kgH.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.kgM.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.kgO = new com.baidu.tbadk.data.c();
                    this.kgO.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.kgP = new com.baidu.tbadk.data.f();
                    this.kgP.a(post.lbs_info);
                }
                this.cSV = post.storecount.intValue();
                this.kgL.a(post.present);
                this.cSy.setUserMap(this.userMap);
                this.cSy.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.iWn = new SmallTailInfo();
                    this.iWn.id = post.signature.signature_id.intValue();
                    this.iWn.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.iWn.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.iWn.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.iWn.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.cTh.add(cVar);
                    }
                }
                this.cTk = post.skin_info;
                this.cTn = post.lego_card;
                this.kgZ = post.tpoint_post;
                if (post.agree != null) {
                    this.kha = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.kha = false;
                }
                this.khh = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.cTQ = new OriginalThreadInfo();
                    this.cTQ.a(post.origin_thread_info);
                } else {
                    this.cTQ = null;
                }
                this.khk = post.is_fold.intValue();
                this.iCi = post.fold_tip;
                this.kho = post.is_top_agree_post.intValue() == 1;
                this.khp = post.show_squared.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int mColorId;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(this.mColorId));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> khy;
        private b khz;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.khy = new SoftReference<>(context);
            this.khz = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.khy != null && this.khy.get() != null) {
                if (this.khz != null) {
                    this.khz.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.khy.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String fw(Context context) {
        ArrayList<TbRichTextData> aTS;
        if (this.kgK == null || (aTS = this.kgK.aTS()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = aTS.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.aTZ().toString());
            } else if (next.getType() == 17) {
                String str = next.aUd().mGifInfo.mSharpText;
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

    public String cLf() {
        ArrayList<TbRichTextData> aTS;
        String str;
        if (this.kgK == null || (aTS = this.kgK.aTS()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = aTS.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.aTZ().toString());
                } else if (next.getType() == 17) {
                    if (next.aUd() != null && next.aUd().mGifInfo != null && (str = next.aUd().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo cLg() {
        ArrayList<TbRichTextData> aTS;
        if (this.kgK != null && (aTS = this.kgK.aTS()) != null) {
            Iterator<TbRichTextData> it = aTS.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.aTY().getWidth();
                    preLoadImageInfo.height = next.aTY().getHeight();
                    preLoadImageInfo.imgUrl = next.aTY().aUl();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.aUe().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.aUe().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.aUe().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String cLh() {
        k cKI;
        PreLoadImageInfo cLg = cLg();
        if (cLg != null && !StringUtils.isNull(cLg.imgUrl)) {
            return cLg.imgUrl;
        }
        if (this.kgS != null && (cKI = this.kgS.cKI()) != null && !StringUtils.isNull(cKI.cKJ())) {
            return cKI.cKJ();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> aTS;
        if (this.kgK == null || (aTS = this.kgK.aTS()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = aTS.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.aTY().getWidth();
                preLoadImageInfo.height = next.aTY().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.aTY().aUq()) {
                    preLoadImageInfo.imgUrl = next.aTY().aUm();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.aTY().aUl();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.aUd() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.aUd().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.aUd().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.aUd();
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
        if (this.cSn == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.cSn.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.kgB == 52) {
            return kgx;
        }
        if (this.kgB == 1) {
            return cTl;
        }
        if (this.kgB == 36) {
            return kgu;
        }
        if (this.kgB == 40 || this.kgB == 50) {
            return cRz;
        }
        if (this.kgB == 41) {
            return kgv;
        }
        if (this.kgB == 53) {
            return kgy;
        }
        if (cLa() == 1) {
            return kgs;
        }
        return kgt;
    }

    public void setPostType(int i) {
        this.kgB = i;
    }

    public ar cLi() {
        return this.kgL;
    }

    public void a(ar arVar) {
        this.kgL = arVar;
    }

    public i cLj() {
        return this.kgS;
    }

    public com.baidu.tbadk.widget.richText.i aUc() {
        if (this.kgW != null) {
            return this.kgW;
        }
        if (this.kgK != null && v.getCount(this.kgK.aTS()) > 0) {
            Iterator<TbRichTextData> it = this.kgK.aTS().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.kgW = next.aUc();
                    return this.kgW;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo aUa() {
        if (this.diq != null) {
            return this.diq;
        }
        if (this.kgK != null && v.getCount(this.kgK.aTS()) > 0) {
            Iterator<TbRichTextData> it = this.kgK.aTS().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.diq = next.aUa();
                    return this.diq;
                }
            }
        }
        return null;
    }

    public String cLk() {
        return this.kgX;
    }

    public String aDu() {
        return this.cTn;
    }

    public void aDw() {
        if (this.cSK == 0) {
            this.cSK = 1;
        }
    }

    public long aDI() {
        return this.agreeData.disAgreeNum;
    }

    public AgreeData aEa() {
        return this.agreeData;
    }

    public OriginalThreadInfo cLl() {
        return this.cTQ;
    }

    public void h(OriginalThreadInfo originalThreadInfo) {
        this.cTQ = originalThreadInfo;
    }

    public int cLm() {
        return this.khk;
    }

    public String ckC() {
        return this.iCi;
    }

    public boolean cLn() {
        return this.khp;
    }
}
