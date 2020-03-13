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
    private OriginalThreadInfo cTR;
    private SkinInfo cTl;
    private String cTo;
    private TbRichTextVoiceInfo diF;
    private String iCu;
    private SmallTailInfo iWz;
    private String kgP;
    private ArrayList<PostData> kgT;
    private boolean khB;
    public an khD;
    private com.baidu.tbadk.data.c kha;
    private com.baidu.tbadk.data.f khb;
    private i khe;
    private bf khf;
    public boolean khh;
    private com.baidu.tbadk.widget.richText.i khi;
    private String khj;
    private String khk;
    private TPointPost khl;
    public int kho;
    public boolean khr;
    public AlaLiveInfoCoreData khu;
    private boolean khy;
    public int locate;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId kgE = BdUniqueId.gen();
    public static final BdUniqueId kgF = BdUniqueId.gen();
    public static final BdUniqueId cTm = BdUniqueId.gen();
    public static final BdUniqueId kgG = BdUniqueId.gen();
    public static final BdUniqueId cRA = BdUniqueId.gen();
    public static final BdUniqueId kgH = BdUniqueId.gen();
    public static final BdUniqueId kgI = BdUniqueId.gen();
    public static final BdUniqueId kgJ = BdUniqueId.gen();
    public static final BdUniqueId kgK = BdUniqueId.gen();
    public static final BdUniqueId kgL = BdUniqueId.gen();
    public static boolean kgM = false;
    private int kgN = 0;
    private boolean kgU = false;
    private ArrayList<PostData> kgV = null;
    private TbRichText kgW = null;
    private boolean kgZ = false;
    private boolean khc = false;
    private boolean khd = false;
    public boolean khg = false;
    public int cSL = 0;
    private boolean khm = false;
    public boolean gvR = false;
    public boolean khn = false;
    public boolean khp = false;
    public boolean khq = true;
    public boolean khs = false;
    public boolean kht = false;
    private boolean khv = false;
    private int khw = 0;
    private boolean khx = true;
    public boolean khz = false;
    public boolean khA = false;
    public boolean khC = false;
    private b khE = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.khD != null) {
                an aGy = PostData.this.khD.aGy();
                aGy.delete("obj_locate");
                aGy.X("obj_locate", 7);
                TiebaStatic.log(aGy);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int kgO = 0;
    private long time = 0;
    private String date = null;
    private MetaData cSo = new MetaData();
    private ArrayList<l> kgQ = new ArrayList<>();
    private ArrayList<l> kgR = new ArrayList<>();
    private int kgS = 0;
    private int cSW = 0;
    private PraiseData cSz = new PraiseData();
    private ar kgX = new ar();
    private c kgY = new c();
    private ArrayList<com.baidu.tbadk.data.c> cTi = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.kgT = null;
        this.kho = 0;
        this.kgT = new ArrayList<>();
        this.kho = 0;
    }

    public void sK(boolean z) {
        this.khy = z;
    }

    public boolean cKT() {
        return this.khy;
    }

    public ArrayList<PostData> cKU() {
        return this.kgV;
    }

    public void cKV() {
        this.kgV.clear();
        this.kgV = null;
        this.kgU = false;
    }

    public void t(PostData postData) {
        if (postData != null) {
            if (this.kgV == null) {
                this.kgV = new ArrayList<>();
                if (v.getCount(this.kgT) > 2) {
                    this.kgV.addAll(v.subList(this.kgT, 0, 2));
                } else {
                    this.kgV.addAll(this.kgT);
                }
            }
            this.kgV.add(postData);
        }
    }

    public void u(PostData postData) {
        if (postData != null && this.kgT != null) {
            this.kgT.add(postData);
            cKZ();
        }
    }

    public void Jc(String str) {
        if (this.kgV != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.kgV.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.kgV.remove(next);
                    return;
                }
            }
        }
    }

    public void sL(boolean z) {
        this.khx = z;
    }

    public boolean cKW() {
        return this.khx;
    }

    public void sM(boolean z) {
        this.kgU = z;
    }

    public boolean cKX() {
        return this.kgU;
    }

    public ArrayList<PostData> cKY() {
        return this.kgT;
    }

    public void cKZ() {
        this.kgS++;
    }

    public void cLa() {
        this.kgS--;
    }

    public void Cv(int i) {
        this.kgS = i;
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

    public int cLb() {
        return this.kgO;
    }

    public void Cw(int i) {
        this.kgO = i;
    }

    public boolean cLc() {
        return this.khd;
    }

    public void sN(boolean z) {
        this.khd = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = aq.getFormatTime(j);
    }

    public MetaData aCo() {
        return this.cSo;
    }

    public void a(MetaData metaData) {
        this.cSo = metaData;
    }

    public void a(PraiseData praiseData) {
        this.cSz = praiseData;
    }

    public TbRichText cLd() {
        return this.kgW;
    }

    public void c(TbRichText tbRichText) {
        this.kgW = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo csa() {
        return this.iWz;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.iWz = smallTailInfo;
    }

    public com.baidu.tbadk.data.f cLe() {
        return this.khb;
    }

    public SkinInfo aCJ() {
        return this.cTl;
    }

    public void sO(boolean z) {
        this.khv = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.kgW != null && this.kgW.aTT() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.cSo != null && this.cSo.getIs_bawu() == 1) {
                    if (this.khy) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.cSo.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.cSo.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.cSo.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.cSo.getBawu_type())) {
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
                                            PostData.this.kgW.isChanged = true;
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
            if (!StringUtils.isNull(this.cSo.getSealPrefix())) {
                sb.append(HanziToPinyin.Token.SEPARATOR);
                sb.append(this.cSo.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(HanziToPinyin.Token.SEPARATOR);
            }
            String sb2 = sb.toString();
            if (this.cSo == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.cSo.getName_show() + str + "：");
                str2 = this.cSo.getUserName();
                str3 = this.cSo.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.cSo.getSealPrefix())) {
                Bitmap bitmap = am.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable);
                jVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.cSo.getSealPrefix().length() + 1;
                spannableString.setSpan(jVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.khE), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.cSo != null && this.cSo.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b e = e(z, this.cSo != null && this.cSo.getIs_bawu() == 1, str);
                if (e != null) {
                    if (this.cSo != null) {
                        int i3 = 0;
                        if (this.cSo.getName_show() != null) {
                            i3 = this.cSo.getName_show().length();
                        }
                        spannableString.setSpan(e, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(e, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> aTT = this.kgW.aTT();
            if (aTT != null && aTT.size() > 0) {
                TbRichTextData tbRichTextData2 = aTT.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.aUa() != null) {
                    if (this.khv) {
                        int indexOf = tbRichTextData2.aUa().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.aUa().delete(0, indexOf + 1);
                        }
                        this.khv = false;
                    }
                    tbRichTextData2.nt(sb.length());
                    tbRichTextData2.aUa().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= aTT.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (aTT.get(i5) == null || aTT.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo aUb = aTT.get(i5).aUb();
                            aTT.remove(i5);
                            tbRichTextVoiceInfo = aUb;
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
                    aTT.add(0, tbRichTextData);
                }
            }
            this.khz = true;
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
            bVar.tS(str);
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

    public int cLf() {
        return this.kgS;
    }

    public void fu(Context context) {
        int type;
        int i;
        int i2;
        if (this.kgQ != null) {
            int i3 = -1;
            int size = this.kgR.size();
            if (size > 0) {
                try {
                    i3 = this.kgR.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.kgQ.size()) {
                l lVar = this.kgQ.get(i4);
                if (l.cK(i5, lVar.getType())) {
                    this.kgR.get(size - 1).b(lVar.ft(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.kgR.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.ft(context));
                        this.kgR.add(lVar2);
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
            if (this.kgW != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.kgW.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.kgR == null || this.kgR.size() == 0) {
                fu(context);
            }
            ArrayList<l> arrayList = this.kgR;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.cKM() != null) {
                            sb.append((CharSequence) next.cKM());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String ve = TbFaceManager.aPQ().ve(next.getText());
                        if (ve != null) {
                            sb.append("[");
                            sb.append(ve);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !aq.isEmpty(next.cKL())) {
                        sb.append("[").append(next.cKL()).append("]");
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
                this.kgO = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = aq.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.khc = subPostList.is_giftpost.intValue() == 1;
                this.agreeData.postId = this.id;
                this.agreeData.parseProtobuf(subPostList.agree);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.cSo = metaData;
                }
                if (this.cSo.getUserId() == null || this.cSo.getUserId().length() <= 0 || this.cSo.getUserId().equals("0")) {
                    this.cSo = metaData2;
                }
                this.kgW = TbRichTextView.a(context, subPostList.content, z);
                if (this.kgW != null) {
                    this.kgW.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
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
                this.kgO = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = aq.getFormatTime(this.time);
                this.kgP = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.cSo = metaData;
                }
                this.gvR = post.need_log.intValue() == 1;
                this.khn = post.img_num_abtest.intValue() == 1;
                this.khf = new bf();
                this.khf.parserProtobuf(post.from_forum);
                if (this.cSo.getUserId() == null || this.cSo.getUserId().length() <= 0 || this.cSo.getUserId().equals("0")) {
                    this.cSo.parserProtobuf(post.author);
                }
                if (this.cSo != null && context != null) {
                    this.khj = this.cSo.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.khk = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.cSo.getLevel_id()));
                }
                this.kgZ = post.is_ntitle.intValue() == 1;
                this.kgS = post.sub_post_number.intValue();
                this.khe = new i(post.tpoint_post);
                this.kgW = TbRichTextView.a(context, post.content, true);
                if (this.kgW != null) {
                    this.kgW.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.kgW.ns(this.kgO);
                    if (this.cSo != null) {
                        this.kgW.setAuthorId(this.cSo.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.khc = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.sK(this.khy);
                            postData.a(subPostList, context);
                            this.kgT.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.kgY.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.kha = new com.baidu.tbadk.data.c();
                    this.kha.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.khb = new com.baidu.tbadk.data.f();
                    this.khb.a(post.lbs_info);
                }
                this.cSW = post.storecount.intValue();
                this.kgX.a(post.present);
                this.cSz.setUserMap(this.userMap);
                this.cSz.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.iWz = new SmallTailInfo();
                    this.iWz.id = post.signature.signature_id.intValue();
                    this.iWz.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.iWz.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.iWz.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.iWz.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.cTi.add(cVar);
                    }
                }
                this.cTl = post.skin_info;
                this.cTo = post.lego_card;
                this.khl = post.tpoint_post;
                if (post.agree != null) {
                    this.khm = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.khm = false;
                }
                this.kht = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.cTR = new OriginalThreadInfo();
                    this.cTR.a(post.origin_thread_info);
                } else {
                    this.cTR = null;
                }
                this.khw = post.is_fold.intValue();
                this.iCu = post.fold_tip;
                this.khA = post.is_top_agree_post.intValue() == 1;
                this.khB = post.show_squared.intValue() == 1;
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
        private SoftReference<Context> khK;
        private b khL;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.khK = new SoftReference<>(context);
            this.khL = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.khK != null && this.khK.get() != null) {
                if (this.khL != null) {
                    this.khL.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.khK.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String fw(Context context) {
        ArrayList<TbRichTextData> aTT;
        if (this.kgW == null || (aTT = this.kgW.aTT()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = aTT.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.aUa().toString());
            } else if (next.getType() == 17) {
                String str = next.aUe().mGifInfo.mSharpText;
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

    public String cLg() {
        ArrayList<TbRichTextData> aTT;
        String str;
        if (this.kgW == null || (aTT = this.kgW.aTT()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = aTT.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.aUa().toString());
                } else if (next.getType() == 17) {
                    if (next.aUe() != null && next.aUe().mGifInfo != null && (str = next.aUe().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo cLh() {
        ArrayList<TbRichTextData> aTT;
        if (this.kgW != null && (aTT = this.kgW.aTT()) != null) {
            Iterator<TbRichTextData> it = aTT.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.aTZ().getWidth();
                    preLoadImageInfo.height = next.aTZ().getHeight();
                    preLoadImageInfo.imgUrl = next.aTZ().aUm();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.aUf().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.aUf().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.aUf().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String cLi() {
        k cKJ;
        PreLoadImageInfo cLh = cLh();
        if (cLh != null && !StringUtils.isNull(cLh.imgUrl)) {
            return cLh.imgUrl;
        }
        if (this.khe != null && (cKJ = this.khe.cKJ()) != null && !StringUtils.isNull(cKJ.cKK())) {
            return cKJ.cKK();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> aTT;
        if (this.kgW == null || (aTT = this.kgW.aTT()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = aTT.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.aTZ().getWidth();
                preLoadImageInfo.height = next.aTZ().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.aTZ().aUr()) {
                    preLoadImageInfo.imgUrl = next.aTZ().aUn();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.aTZ().aUm();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.aUe() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.aUe().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.aUe().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.aUe();
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
        if (this.cSo == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.cSo.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.kgN == 52) {
            return kgJ;
        }
        if (this.kgN == 1) {
            return cTm;
        }
        if (this.kgN == 36) {
            return kgG;
        }
        if (this.kgN == 40 || this.kgN == 50) {
            return cRA;
        }
        if (this.kgN == 41) {
            return kgH;
        }
        if (this.kgN == 53) {
            return kgK;
        }
        if (cLb() == 1) {
            return kgE;
        }
        return kgF;
    }

    public void setPostType(int i) {
        this.kgN = i;
    }

    public ar cLj() {
        return this.kgX;
    }

    public void a(ar arVar) {
        this.kgX = arVar;
    }

    public i cLk() {
        return this.khe;
    }

    public com.baidu.tbadk.widget.richText.i aUd() {
        if (this.khi != null) {
            return this.khi;
        }
        if (this.kgW != null && v.getCount(this.kgW.aTT()) > 0) {
            Iterator<TbRichTextData> it = this.kgW.aTT().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.khi = next.aUd();
                    return this.khi;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo aUb() {
        if (this.diF != null) {
            return this.diF;
        }
        if (this.kgW != null && v.getCount(this.kgW.aTT()) > 0) {
            Iterator<TbRichTextData> it = this.kgW.aTT().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.diF = next.aUb();
                    return this.diF;
                }
            }
        }
        return null;
    }

    public String cLl() {
        return this.khj;
    }

    public String aDu() {
        return this.cTo;
    }

    public void aDw() {
        if (this.cSL == 0) {
            this.cSL = 1;
        }
    }

    public long aDI() {
        return this.agreeData.disAgreeNum;
    }

    public AgreeData aEa() {
        return this.agreeData;
    }

    public OriginalThreadInfo cLm() {
        return this.cTR;
    }

    public void h(OriginalThreadInfo originalThreadInfo) {
        this.cTR = originalThreadInfo;
    }

    public int cLn() {
        return this.khw;
    }

    public String ckD() {
        return this.iCu;
    }

    public boolean cLo() {
        return this.khB;
    }
}
