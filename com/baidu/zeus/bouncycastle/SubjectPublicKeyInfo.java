package com.baidu.zeus.bouncycastle;

import java.util.Enumeration;
/* loaded from: classes.dex */
public class SubjectPublicKeyInfo extends ASN1Encodable {
    private AlgorithmIdentifier algId;
    private DERBitString keyData;

    public static SubjectPublicKeyInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static SubjectPublicKeyInfo getInstance(Object obj) {
        if (obj instanceof SubjectPublicKeyInfo) {
            return (SubjectPublicKeyInfo) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new SubjectPublicKeyInfo((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory");
    }

    public SubjectPublicKeyInfo(AlgorithmIdentifier algorithmIdentifier, DEREncodable dEREncodable) {
        this.keyData = new DERBitString(dEREncodable);
        this.algId = algorithmIdentifier;
    }

    public SubjectPublicKeyInfo(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.keyData = new DERBitString(bArr);
        this.algId = algorithmIdentifier;
    }

    public SubjectPublicKeyInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() != 2) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
        Enumeration objects = aSN1Sequence.getObjects();
        this.algId = AlgorithmIdentifier.getInstance(objects.nextElement());
        this.keyData = DERBitString.getInstance(objects.nextElement());
    }

    public AlgorithmIdentifier getAlgorithmId() {
        return this.algId;
    }

    public DERObject getPublicKey() {
        return new ASN1InputStream(this.keyData.getBytes()).readObject();
    }

    public DERBitString getPublicKeyData() {
        return this.keyData;
    }

    @Override // com.baidu.zeus.bouncycastle.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.algId);
        aSN1EncodableVector.add(this.keyData);
        return new DERSequence(aSN1EncodableVector);
    }
}
