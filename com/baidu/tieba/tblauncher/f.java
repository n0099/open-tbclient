package com.baidu.tieba.tblauncher;

import android.net.Uri;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes16.dex */
public class f {
    public static void B(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM3);
                String queryParameter7 = uri.getQueryParameter("tid");
                String queryParameter8 = uri.getQueryParameter("kw");
                String queryParameter9 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.dFZ);
                String queryParameter10 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.dGa);
                String queryParameter11 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.dGb);
                String queryParameter12 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.dGc);
                String queryParameter13 = uri.getQueryParameter("obj_name");
                String queryParameter14 = uri.getQueryParameter("eqid");
                ap apVar = new ap("c13561");
                apVar.dn("obj_locate", queryParameter2);
                apVar.dn("obj_type", queryParameter3);
                apVar.dn("obj_param1", queryParameter4);
                apVar.dn(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                apVar.dn(TiebaInitialize.Params.OBJ_PARAM3, queryParameter6);
                apVar.dn("tid", queryParameter7);
                apVar.dn("fname", queryParameter8);
                apVar.dn(com.baidu.tbadk.BdToken.f.dFZ, queryParameter9);
                apVar.dn(com.baidu.tbadk.BdToken.f.dGa, queryParameter10);
                apVar.dn(com.baidu.tbadk.BdToken.f.dGb, queryParameter11);
                apVar.dn(com.baidu.tbadk.BdToken.f.dGc, queryParameter12);
                apVar.dn("obj_source", queryParameter);
                apVar.dn("obj_name", queryParameter13);
                apVar.dn("query", queryParameter14);
                TiebaStatic.log(apVar);
            }
        }
    }

    public static void C(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter) || "PC".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter("kw");
                String queryParameter7 = uri.getQueryParameter("obj_name");
                String queryParameter8 = uri.getQueryParameter("fname");
                ap apVar = new ap("c13561");
                apVar.dn("obj_locate", queryParameter2);
                apVar.dn("obj_type", queryParameter3);
                apVar.dn("obj_param1", queryParameter4);
                apVar.dn(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                apVar.dn("fname", queryParameter6);
                apVar.dn("obj_source", queryParameter);
                apVar.dn("obj_name", queryParameter7);
                apVar.dn("fname", queryParameter8);
                TiebaStatic.log(apVar);
            }
        }
    }

    public static void D(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter("kw");
                String queryParameter7 = uri.getQueryParameter("obj_name");
                String queryParameter8 = uri.getQueryParameter("topic_id");
                ap apVar = new ap("c13561");
                apVar.dn("obj_locate", queryParameter2);
                apVar.dn("obj_type", queryParameter3);
                apVar.dn("obj_param1", queryParameter4);
                apVar.dn(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                apVar.dn("fname", queryParameter6);
                apVar.dn("obj_source", queryParameter);
                apVar.dn("obj_name", queryParameter7);
                apVar.dn("topic_id", queryParameter8);
                TiebaStatic.log(apVar);
            }
        }
    }

    public static void E(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter("obj_name");
                ap apVar = new ap("c13561");
                apVar.dn("obj_locate", queryParameter2);
                apVar.dn("obj_type", queryParameter3);
                apVar.dn("obj_param1", queryParameter4);
                apVar.dn(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                apVar.dn("obj_source", queryParameter);
                apVar.dn("obj_name", queryParameter6);
                TiebaStatic.log(apVar);
            }
        }
    }

    public static void F(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter) || "PC".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                uri.getQueryParameter("kw");
                String queryParameter6 = uri.getQueryParameter("obj_name");
                uri.getQueryParameter("fname");
                ap apVar = new ap("c13561");
                apVar.dn("obj_locate", queryParameter2);
                apVar.dn("obj_type", queryParameter3);
                apVar.dn("obj_param1", queryParameter4);
                apVar.dn(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                apVar.dn("obj_source", queryParameter);
                apVar.dn("obj_name", queryParameter6);
                TiebaStatic.log(apVar);
            }
        }
    }
}
