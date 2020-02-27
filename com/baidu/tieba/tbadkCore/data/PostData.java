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
    private OriginalThreadInfo cTP;
    private SkinInfo cTj;
    private String cTm;
    private TbRichTextVoiceInfo dip;
    private String iCg;
    private SmallTailInfo iWl;
    private String kgB;
    private ArrayList<PostData> kgF;
    private com.baidu.tbadk.data.c kgM;
    private com.baidu.tbadk.data.f kgN;
    private i kgQ;
    private bf kgR;
    public boolean kgT;
    private com.baidu.tbadk.widget.richText.i kgU;
    private String kgV;
    private String kgW;
    private TPointPost kgX;
    public int kha;
    public boolean khd;
    public AlaLiveInfoCoreData khg;
    private boolean khk;
    private boolean khn;
    public an khp;
    public int locate;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId kgq = BdUniqueId.gen();
    public static final BdUniqueId kgr = BdUniqueId.gen();
    public static final BdUniqueId cTk = BdUniqueId.gen();
    public static final BdUniqueId kgs = BdUniqueId.gen();
    public static final BdUniqueId cRy = BdUniqueId.gen();
    public static final BdUniqueId kgt = BdUniqueId.gen();
    public static final BdUniqueId kgu = BdUniqueId.gen();
    public static final BdUniqueId kgv = BdUniqueId.gen();
    public static final BdUniqueId kgw = BdUniqueId.gen();
    public static final BdUniqueId kgx = BdUniqueId.gen();
    public static boolean kgy = false;
    private int kgz = 0;
    private boolean kgG = false;
    private ArrayList<PostData> kgH = null;
    private TbRichText kgI = null;
    private boolean kgL = false;
    private boolean kgO = false;
    private boolean kgP = false;
    public boolean kgS = false;
    public int cSJ = 0;
    private boolean kgY = false;
    public boolean gvD = false;
    public boolean kgZ = false;
    public boolean khb = false;
    public boolean khc = true;
    public boolean khe = false;
    public boolean khf = false;
    private boolean khh = false;
    private int khi = 0;
    private boolean khj = true;
    public boolean khl = false;
    public boolean khm = false;
    public boolean kho = false;
    private b khq = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.khp != null) {
                an aGw = PostData.this.khp.aGw();
                aGw.delete("obj_locate");
                aGw.X("obj_locate", 7);
                TiebaStatic.log(aGw);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int kgA = 0;
    private long time = 0;
    private String date = null;
    private MetaData cSm = new MetaData();
    private ArrayList<l> kgC = new ArrayList<>();
    private ArrayList<l> kgD = new ArrayList<>();
    private int kgE = 0;
    private int cSU = 0;
    private PraiseData cSx = new PraiseData();
    private ar kgJ = new ar();
    private c kgK = new c();
    private ArrayList<com.baidu.tbadk.data.c> cTg = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.kgF = null;
        this.kha = 0;
        this.kgF = new ArrayList<>();
        this.kha = 0;
    }

    public void sK(boolean z) {
        this.khk = z;
    }

    public boolean cKQ() {
        return this.khk;
    }

    public ArrayList<PostData> cKR() {
        return this.kgH;
    }

    public void cKS() {
        this.kgH.clear();
        this.kgH = null;
        this.kgG = false;
    }

    public void t(PostData postData) {
        if (postData != null) {
            if (this.kgH == null) {
                this.kgH = new ArrayList<>();
                if (v.getCount(this.kgF) > 2) {
                    this.kgH.addAll(v.subList(this.kgF, 0, 2));
                } else {
                    this.kgH.addAll(this.kgF);
                }
            }
            this.kgH.add(postData);
        }
    }

    public void u(PostData postData) {
        if (postData != null && this.kgF != null) {
            this.kgF.add(postData);
            cKW();
        }
    }

    public void Jb(String str) {
        if (this.kgH != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.kgH.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.kgH.remove(next);
                    return;
                }
            }
        }
    }

    public void sL(boolean z) {
        this.khj = z;
    }

    public boolean cKT() {
        return this.khj;
    }

    public void sM(boolean z) {
        this.kgG = z;
    }

    public boolean cKU() {
        return this.kgG;
    }

    public ArrayList<PostData> cKV() {
        return this.kgF;
    }

    public void cKW() {
        this.kgE++;
    }

    public void cKX() {
        this.kgE--;
    }

    public void Cv(int i) {
        this.kgE = i;
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

    public int cKY() {
        return this.kgA;
    }

    public void Cw(int i) {
        this.kgA = i;
    }

    public boolean cKZ() {
        return this.kgP;
    }

    public void sN(boolean z) {
        this.kgP = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = aq.getFormatTime(j);
    }

    public MetaData aCm() {
        return this.cSm;
    }

    public void a(MetaData metaData) {
        this.cSm = metaData;
    }

    public void a(PraiseData praiseData) {
        this.cSx = praiseData;
    }

    public TbRichText cLa() {
        return this.kgI;
    }

    public void c(TbRichText tbRichText) {
        this.kgI = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo crX() {
        return this.iWl;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.iWl = smallTailInfo;
    }

    public com.baidu.tbadk.data.f cLb() {
        return this.kgN;
    }

    public SkinInfo aCH() {
        return this.cTj;
    }

    public void sO(boolean z) {
        this.khh = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.kgI != null && this.kgI.aTQ() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.cSm != null && this.cSm.getIs_bawu() == 1) {
                    if (this.khk) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.cSm.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.cSm.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.cSm.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.cSm.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = aCm().getTShowInfoNew();
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
                                            PostData.this.kgI.isChanged = true;
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
            if (!StringUtils.isNull(this.cSm.getSealPrefix())) {
                sb.append(HanziToPinyin.Token.SEPARATOR);
                sb.append(this.cSm.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(HanziToPinyin.Token.SEPARATOR);
            }
            String sb2 = sb.toString();
            if (this.cSm == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.cSm.getName_show() + str + "：");
                str2 = this.cSm.getUserName();
                str3 = this.cSm.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.cSm.getSealPrefix())) {
                Bitmap bitmap = am.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable);
                jVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.cSm.getSealPrefix().length() + 1;
                spannableString.setSpan(jVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.khq), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.cSm != null && this.cSm.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b e = e(z, this.cSm != null && this.cSm.getIs_bawu() == 1, str);
                if (e != null) {
                    if (this.cSm != null) {
                        int i3 = 0;
                        if (this.cSm.getName_show() != null) {
                            i3 = this.cSm.getName_show().length();
                        }
                        spannableString.setSpan(e, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(e, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> aTQ = this.kgI.aTQ();
            if (aTQ != null && aTQ.size() > 0) {
                TbRichTextData tbRichTextData2 = aTQ.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.aTX() != null) {
                    if (this.khh) {
                        int indexOf = tbRichTextData2.aTX().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.aTX().delete(0, indexOf + 1);
                        }
                        this.khh = false;
                    }
                    tbRichTextData2.nt(sb.length());
                    tbRichTextData2.aTX().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= aTQ.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (aTQ.get(i5) == null || aTQ.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo aTY = aTQ.get(i5).aTY();
                            aTQ.remove(i5);
                            tbRichTextVoiceInfo = aTY;
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
                    aTQ.add(0, tbRichTextData);
                }
            }
            this.khl = true;
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

    public int cLc() {
        return this.kgE;
    }

    public void fu(Context context) {
        int type;
        int i;
        int i2;
        if (this.kgC != null) {
            int i3 = -1;
            int size = this.kgD.size();
            if (size > 0) {
                try {
                    i3 = this.kgD.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.kgC.size()) {
                l lVar = this.kgC.get(i4);
                if (l.cK(i5, lVar.getType())) {
                    this.kgD.get(size - 1).b(lVar.ft(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.kgD.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.ft(context));
                        this.kgD.add(lVar2);
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
            if (this.kgI != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.kgI.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.kgD == null || this.kgD.size() == 0) {
                fu(context);
            }
            ArrayList<l> arrayList = this.kgD;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.cKJ() != null) {
                            sb.append((CharSequence) next.cKJ());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String vd = TbFaceManager.aPN().vd(next.getText());
                        if (vd != null) {
                            sb.append("[");
                            sb.append(vd);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !aq.isEmpty(next.cKI())) {
                        sb.append("[").append(next.cKI()).append("]");
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
                this.kgA = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = aq.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.kgO = subPostList.is_giftpost.intValue() == 1;
                this.agreeData.postId = this.id;
                this.agreeData.parseProtobuf(subPostList.agree);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.cSm = metaData;
                }
                if (this.cSm.getUserId() == null || this.cSm.getUserId().length() <= 0 || this.cSm.getUserId().equals("0")) {
                    this.cSm = metaData2;
                }
                this.kgI = TbRichTextView.a(context, subPostList.content, z);
                if (this.kgI != null) {
                    this.kgI.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
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
                this.kgA = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = aq.getFormatTime(this.time);
                this.kgB = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.cSm = metaData;
                }
                this.gvD = post.need_log.intValue() == 1;
                this.kgZ = post.img_num_abtest.intValue() == 1;
                this.kgR = new bf();
                this.kgR.parserProtobuf(post.from_forum);
                if (this.cSm.getUserId() == null || this.cSm.getUserId().length() <= 0 || this.cSm.getUserId().equals("0")) {
                    this.cSm.parserProtobuf(post.author);
                }
                if (this.cSm != null && context != null) {
                    this.kgV = this.cSm.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.kgW = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.cSm.getLevel_id()));
                }
                this.kgL = post.is_ntitle.intValue() == 1;
                this.kgE = post.sub_post_number.intValue();
                this.kgQ = new i(post.tpoint_post);
                this.kgI = TbRichTextView.a(context, post.content, true);
                if (this.kgI != null) {
                    this.kgI.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.kgI.ns(this.kgA);
                    if (this.cSm != null) {
                        this.kgI.setAuthorId(this.cSm.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.kgO = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.sK(this.khk);
                            postData.a(subPostList, context);
                            this.kgF.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.kgK.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.kgM = new com.baidu.tbadk.data.c();
                    this.kgM.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.kgN = new com.baidu.tbadk.data.f();
                    this.kgN.a(post.lbs_info);
                }
                this.cSU = post.storecount.intValue();
                this.kgJ.a(post.present);
                this.cSx.setUserMap(this.userMap);
                this.cSx.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.iWl = new SmallTailInfo();
                    this.iWl.id = post.signature.signature_id.intValue();
                    this.iWl.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.iWl.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.iWl.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.iWl.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.cTg.add(cVar);
                    }
                }
                this.cTj = post.skin_info;
                this.cTm = post.lego_card;
                this.kgX = post.tpoint_post;
                if (post.agree != null) {
                    this.kgY = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.kgY = false;
                }
                this.khf = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.cTP = new OriginalThreadInfo();
                    this.cTP.a(post.origin_thread_info);
                } else {
                    this.cTP = null;
                }
                this.khi = post.is_fold.intValue();
                this.iCg = post.fold_tip;
                this.khm = post.is_top_agree_post.intValue() == 1;
                this.khn = post.show_squared.intValue() == 1;
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
        private SoftReference<Context> khw;
        private b khx;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.khw = new SoftReference<>(context);
            this.khx = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.khw != null && this.khw.get() != null) {
                if (this.khx != null) {
                    this.khx.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.khw.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String fw(Context context) {
        ArrayList<TbRichTextData> aTQ;
        if (this.kgI == null || (aTQ = this.kgI.aTQ()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = aTQ.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.aTX().toString());
            } else if (next.getType() == 17) {
                String str = next.aUb().mGifInfo.mSharpText;
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

    public String cLd() {
        ArrayList<TbRichTextData> aTQ;
        String str;
        if (this.kgI == null || (aTQ = this.kgI.aTQ()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = aTQ.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.aTX().toString());
                } else if (next.getType() == 17) {
                    if (next.aUb() != null && next.aUb().mGifInfo != null && (str = next.aUb().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo cLe() {
        ArrayList<TbRichTextData> aTQ;
        if (this.kgI != null && (aTQ = this.kgI.aTQ()) != null) {
            Iterator<TbRichTextData> it = aTQ.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.aTW().getWidth();
                    preLoadImageInfo.height = next.aTW().getHeight();
                    preLoadImageInfo.imgUrl = next.aTW().aUj();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.aUc().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.aUc().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.aUc().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String cLf() {
        k cKG;
        PreLoadImageInfo cLe = cLe();
        if (cLe != null && !StringUtils.isNull(cLe.imgUrl)) {
            return cLe.imgUrl;
        }
        if (this.kgQ != null && (cKG = this.kgQ.cKG()) != null && !StringUtils.isNull(cKG.cKH())) {
            return cKG.cKH();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> aTQ;
        if (this.kgI == null || (aTQ = this.kgI.aTQ()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = aTQ.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.aTW().getWidth();
                preLoadImageInfo.height = next.aTW().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.aTW().aUo()) {
                    preLoadImageInfo.imgUrl = next.aTW().aUk();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.aTW().aUj();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.aUb() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.aUb().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.aUb().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.aUb();
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
        if (this.cSm == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.cSm.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.kgz == 52) {
            return kgv;
        }
        if (this.kgz == 1) {
            return cTk;
        }
        if (this.kgz == 36) {
            return kgs;
        }
        if (this.kgz == 40 || this.kgz == 50) {
            return cRy;
        }
        if (this.kgz == 41) {
            return kgt;
        }
        if (this.kgz == 53) {
            return kgw;
        }
        if (cKY() == 1) {
            return kgq;
        }
        return kgr;
    }

    public void setPostType(int i) {
        this.kgz = i;
    }

    public ar cLg() {
        return this.kgJ;
    }

    public void a(ar arVar) {
        this.kgJ = arVar;
    }

    public i cLh() {
        return this.kgQ;
    }

    public com.baidu.tbadk.widget.richText.i aUa() {
        if (this.kgU != null) {
            return this.kgU;
        }
        if (this.kgI != null && v.getCount(this.kgI.aTQ()) > 0) {
            Iterator<TbRichTextData> it = this.kgI.aTQ().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.kgU = next.aUa();
                    return this.kgU;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo aTY() {
        if (this.dip != null) {
            return this.dip;
        }
        if (this.kgI != null && v.getCount(this.kgI.aTQ()) > 0) {
            Iterator<TbRichTextData> it = this.kgI.aTQ().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.dip = next.aTY();
                    return this.dip;
                }
            }
        }
        return null;
    }

    public String cLi() {
        return this.kgV;
    }

    public String aDs() {
        return this.cTm;
    }

    public void aDu() {
        if (this.cSJ == 0) {
            this.cSJ = 1;
        }
    }

    public long aDG() {
        return this.agreeData.disAgreeNum;
    }

    public AgreeData aDY() {
        return this.agreeData;
    }

    public OriginalThreadInfo cLj() {
        return this.cTP;
    }

    public void h(OriginalThreadInfo originalThreadInfo) {
        this.cTP = originalThreadInfo;
    }

    public int cLk() {
        return this.khi;
    }

    public String ckA() {
        return this.iCg;
    }

    public boolean cLl() {
        return this.khn;
    }
}
