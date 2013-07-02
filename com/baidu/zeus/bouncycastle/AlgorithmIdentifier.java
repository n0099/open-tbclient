package com.baidu.zeus.bouncycastle;
/* loaded from: classes.dex */
public class AlgorithmIdentifier extends ASN1Encodable {
    private DERObjectIdentifier objectId;
    private DEREncodable parameters;
    private boolean parametersDefined;

    public static AlgorithmIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static AlgorithmIdentifier getInstance(Object obj) {
        if (obj == null || (obj instanceof AlgorithmIdentifier)) {
            return (AlgorithmIdentifier) obj;
        }
        if (obj instanceof DERObjectIdentifier) {
            return new AlgorithmIdentifier((DERObjectIdentifier) obj);
        }
        if (obj instanceof String) {
            return new AlgorithmIdentifier((String) obj);
        }
        if (obj instanceof ASN1Sequence) {
            return new AlgorithmIdentifier((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory");
    }

    public AlgorithmIdentifier(DERObjectIdentifier dERObjectIdentifier) {
        this.parametersDefined = false;
        this.objectId = dERObjectIdentifier;
    }

    public AlgorithmIdentifier(String str) {
        this.parametersDefined = false;
        this.objectId = new DERObjectIdentifier(str);
    }

    public AlgorithmIdentifier(DERObjectIdentifier dERObjectIdentifier, DEREncodable dEREncodable) {
        this.parametersDefined = false;
        this.parametersDefined = true;
        this.objectId = dERObjectIdentifier;
        this.parameters = dEREncodable;
    }

    public AlgorithmIdentifier(ASN1Sequence aSN1Sequence) {
        this.parametersDefined = false;
        if (aSN1Sequence.size() < 1 || aSN1Sequence.size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
        this.objectId = DERObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() == 2) {
            this.parametersDefined = true;
            this.parameters = aSN1Sequence.getObjectAt(1);
            return;
        }
        this.parameters = null;
    }

    public DERObjectIdentifier getObjectId() {
        return this.objectId;
    }

    public DEREncodable getParameters() {
        return this.parameters;
    }

    @Override // com.baidu.zeus.bouncycastle.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.objectId);
        if (this.parametersDefined) {
            aSN1EncodableVector.add(this.parameters);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
